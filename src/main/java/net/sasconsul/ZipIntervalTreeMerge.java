package net.sasconsul;

import com.brein.time.timeintervals.collections.ListIntervalCollection;
import com.brein.time.timeintervals.indexes.IntervalTree;
import com.brein.time.timeintervals.indexes.IntervalTreeBuilder;
import com.brein.time.timeintervals.intervals.LongInterval;

import java.util.ArrayList;
import java.util.Iterator;

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
             tree.add(new LongInterval((long)i.start, (long)i.end));
        }



        ArrayList<Interval> ans = new ArrayList<>();
        return ans;
    }
}
