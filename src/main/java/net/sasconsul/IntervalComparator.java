package net.sasconsul;

import java.util.Comparator;

public class IntervalComparator implements Comparator {
    public int compare(Object o1, Object o2) {
        Interval i1 = (Interval) o1;
        Interval i2 = (Interval) o2;
        return i1.start - i2.start;
    }
}
