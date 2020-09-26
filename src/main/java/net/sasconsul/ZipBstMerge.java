package net.sasconsul;

import java.util.ArrayList;
import java.util.Iterator;

public class ZipBstMerge {
    /**
     *  Merge the intervals as required
     *
     * @param intervals
     * @return
     */
    public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if (intervals.size() == 0)
            return intervals;
        if (intervals.size() == 1)
            return intervals;

        ArrayList<Interval> ans = new ArrayList<>(intervals.size());

        Iterator<Interval> ii = intervals.iterator();
        IntervalNode root = new IntervalNode(ii.next());
        int count = 0;
        while(ii.hasNext()) {
            IntervalNode.add(root, ii.next());
            count++;
        }

        return IntervalNode.toArrayListRecurse(ans,root);
    }
}
