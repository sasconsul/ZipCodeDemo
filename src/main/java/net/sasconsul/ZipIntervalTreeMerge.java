package net.sasconsul;

import com.brein.time.timeintervals.collections.ListIntervalCollection;
import com.brein.time.timeintervals.filters.IntervalFilter;
import com.brein.time.timeintervals.indexes.IntervalTree;
import com.brein.time.timeintervals.indexes.IntervalTreeBuilder;
import com.brein.time.timeintervals.indexes.IntervalValueComparator;
import com.brein.time.timeintervals.intervals.AllenIntervalRelation;
import com.brein.time.timeintervals.intervals.IInterval;
import com.brein.time.timeintervals.intervals.LongInterval;
import com.brein.time.timeintervals.intervals.NumberInterval;

import java.util.*;
import java.util.stream.Stream;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.minBy;
import static java.util.stream.Collectors.teeing;

import static java.util.stream.Collectors.summarizingLong;

public class ZipIntervalTreeMerge {
    public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if (intervals.size() == 0)
            return intervals;
        if (intervals.size() == 1)
            return intervals;

        final IntervalTree tree = IntervalTreeBuilder.newBuilder()
                .usePredefinedType(IntervalTreeBuilder.IntervalType.LONG)
                .collectIntervals(interval -> new ListIntervalCollection())
                .build();
        for (Iterator<Interval> it = intervals.iterator(); it.hasNext(); ) {
            Interval i = it.next();
            merge(tree, new LongInterval((long) i.start, (long) i.end));
        }

        ArrayList<Interval> ans = new ArrayList<>();
        return ans;
    }

    /**
     *  Merge Intervals together
     *
     * @param tree
     * @param interval
     */
    private static void merge(IntervalTree tree, LongInterval interval) {

        // Nothing to merge just add
        if (tree.size() == 0) {
            tree.add(interval);
            return;
        }

        // check each for
        // - overlaps
        // - Abuts on either end
        Collection<IInterval> mergeCollection = tree.find(interval, mergefilter);

        // foreach collect the intervals with each other into one interval
        coalesceIntervalsToTree(tree, mergeCollection);
    }

    private static Set<AllenIntervalRelation> OK = EnumSet.of(
            AllenIntervalRelation.ENDS_DIRECTLY_BEFORE,
            AllenIntervalRelation.STARTS_DIRECTLY_BEFORE,
            AllenIntervalRelation.OVERLAPS,
            AllenIntervalRelation.INCLUDES
    );

    // filter to pass over the tree once.
    private static IntervalFilter mergefilter = (IntervalFilter) (comparator, i1, i2) -> {
        AllenIntervalRelation aIR = AllenIntervalRelation.determineRelation((NumberInterval) i1, i2);
        return (OK.contains(aIR));
    };

  // Coalesce the intervals
    private static void coalesceIntervalsToTree(IntervalTree tree, Collection<IInterval> overlaps) {
        if (overlaps.size() ==0)
            return;

        final Long start = overlaps.stream().collect(summarizingLong(IInterval<Long>::getNormStart)).getMin();
        final Long end = overlaps.stream().collect(summarizingLong(IInterval<Long>::getNormEnd)).getMax();
        LongInterval mergedInterval = new LongInterval(start, end);

        //FIXME this should collect the min and max in one pass.
//        LongInterval mergedInterval = (LongInterval) overlaps.stream()
//                .collect(teeing(minBy(Comparator.comparing(LongInterval::getNormStart)),
//                                maxBy(Comparator.comparing(LongInterval::getNormEnd)),
//                                        (min, max) -> new LongInterval(min.get().getNormStart(), max.get().getNormEnd())
//                        ));
        overlaps.forEach(x -> tree.remove(x));
        tree.add(mergedInterval);
    }
}
