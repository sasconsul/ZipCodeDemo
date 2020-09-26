package net.sasconsul;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HugeZipDataProviderClass {
    @DataProvider(name = "huge-zip-data-provider")
    public static Object[][] dataProviderMethod() {

        List<Interval> intervalList = IntStream.range(10000, 99999).mapToObj(i -> new Interval(i, i)).collect(Collectors.toList());
        ArrayList<Interval> inputIntervals = new ArrayList<>(intervalList);
        ArrayList<Interval> expectedIntervals = new ArrayList<>(intervalList);

        return new Object[][]{{inputIntervals, expectedIntervals, "Huge number of simple intervals"}
        };
    }
}
