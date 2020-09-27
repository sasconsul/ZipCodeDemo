package net.sasconsul;

import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    public Interval(int s, int e) {
        start = s;
        end = e;
    }

    @Override
    public String toString() {
        return "[" + start + ", " + end + "] ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Interval Interval = (Interval) o;
        return start == Interval.start &&
                end == Interval.end;
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }

    // Static members
    public static String PATTERN = "(\\[(\\d+),(\\d+)\\])";
    public static Pattern pattern = Pattern.compile(PATTERN, 0);

    public static ArrayList<Interval> getIntervals(String input) {
        ArrayList<Interval> x = new ArrayList<>();

        // check for valid data.
        if (input == null || input.isEmpty() || input.isBlank()) {
            return x;
        }

        // split into intervals.
        String[] ranges = input.split(" ");
        for (int i = 0; i < ranges.length; i++) {
            Matcher m = pattern.matcher(ranges[i]);
            if (m.matches()){
                int start = Integer.parseInt(m.group(2));
                int end = Integer.parseInt(m.group(3));
                Interval Interval = new Interval(start, end);
                x.add(Interval);
            }
        }

        return x;
    }

    public static void printIntervals(ArrayList<Interval> r) {
        for (Interval i : r) {
            System.out.print(i.toString()+" ");
        }
    }

}
