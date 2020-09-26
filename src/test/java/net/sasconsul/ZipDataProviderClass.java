package net.sasconsul;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ZipDataProviderClass
{
    @DataProvider(name = "zip-data-provider")
    public static Object[][] dataProviderMethod()
    {
        return new Object[][] {
                { Interval.getIntervals("[]"), Interval.getIntervals("[]" ), "Null list"},
                { Interval.getIntervals("[1,5]"), Interval.getIntervals("[1,5]" ), "Single Interval"},
                { Interval.getIntervals("[5,5]"), Interval.getIntervals("[5,5]" ), "Single range Interval"},
                { Interval.getIntervals("[1,3] [3,5]"), Interval.getIntervals("[1,5]" ), "Simple merged intervals"},
                { Interval.getIntervals("[3,5] [1,3] "), Interval.getIntervals("[1,5]" ), "Out of order intervals"},
                { Interval.getIntervals("[1,4] [3,5]"), Interval.getIntervals("[1,5]" ), "Overlaping intervals"},
                { Interval.getIntervals("[1,4] [3,5] [4,6]"), Interval.getIntervals("[1,6]" ), "Three Overlaping intervals"},
                { Interval.getIntervals("[1,4] [3,5] [6,6] [6,9]"), Interval.getIntervals("[1,5] [6,9]" ), "Some Overlaping intervals"},
                { Interval.getIntervals("[94133,94133] [94200,94299] [94600,94699]"), Interval.getIntervals("[94133,94133] [94200,94299] [94600,94699]" ), "No zip merges needed"},
                { Interval.getIntervals("[94133,94133] [94200,94299] [94226,94399]"), Interval.getIntervals("[94133,94133] [94200,94399]" ), "One Zip merge"},
        };
    }
}
