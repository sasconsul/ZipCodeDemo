package net.sasconsul;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.*;

public class ZipIntervalTreeMergeTest {

    @Test(dataProvider = "zip-data-provider", dataProviderClass = ZipDataProviderClass.class)
    public void testMerge(ArrayList<Interval> input, ArrayList<Interval> expected, String label) {
        ArrayList<Interval> results = ZipIntervalTreeMerge.merge(input);
        Assert.assertEquals(results, expected, label);
    }

    @Test(dataProvider = "large-merging-zip-data-provider", dataProviderClass = LargeMergingZipDataProvider.class, timeOut = 200000)
    public void testLargeMergingMerge(ArrayList<Interval> input, ArrayList<Interval> expected, String label) {
        ArrayList<Interval> results = ZipIntervalTreeMerge.merge(input);
        Assert.assertEquals(results, expected, label);
    }

    @Test(dataProvider = "large-pathological-zip-data-provider", dataProviderClass = LargePathologicalZipDataProviderClass.class, timeOut = 200000)
    public void testLargeMerge(ArrayList<Interval> input, ArrayList<Interval> expected, String label) {
        ArrayList<Interval> results = ZipIntervalTreeMerge.merge(input);
        Assert.assertEquals(results, expected, label);
    }

    @Ignore // because of TestNG bug
    @Test(dataProvider = "huge-zip-data-provider", dataProviderClass = HugeZipDataProviderClass.class, timeOut = 200000)
    public void hugeLargeMerge(ArrayList<Interval> input, ArrayList<Interval> expected, String label) {
        ArrayList<Interval> results = ZipIntervalTreeMerge.merge(input);
        Assert.assertEquals(results, expected, label);
    }
}
