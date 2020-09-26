package net.sasconsul;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LargeMergingZipDataProvider {
    @DataProvider(name = "large-merging-zip-data-provider")
    public static Object[][] dataProviderMethod() {

        List<Interval> intervalList = IntStream.range(0, 10000).mapToObj(i -> new Interval(i, i+1)).collect(Collectors.toList());
        ArrayList<Interval> inputIntervals = new ArrayList<>(intervalList);
        Interval interval = new Interval(0, 10000);
        ArrayList<Interval> expectedIntervals = new ArrayList<>();
        expectedIntervals.add(interval);

        return new Object[][]{{inputIntervals, expectedIntervals, "10000 mergable intervals"}
        };
    }
}
