package net.sasconsul;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class ZipBstMergeTest {

    @Test(dataProvider = "zip-data-provider", dataProviderClass = ZipDataProviderClass.class)
    public void testMerge(ArrayList<Interval> input, ArrayList<Interval> expected, String label) {
        ArrayList<Interval> results = ZipBstMerge.merge(input);
        Assert.assertEquals(results, expected, label);
    }

    @Test(dataProvider = "large-merging-zip-data-provider", dataProviderClass = LargeMergingZipDataProvider.class, timeOut = 200000)
    public void testLargeMergingMerge(ArrayList<Interval> input, ArrayList<Interval> expected, String label) {
        ArrayList<Interval> results = ZipBstMerge.merge(input);
        Assert.assertEquals(results, expected, label);
    }

    // because of stack overflow
    @Ignore
    @Test(dataProvider = "large-pathological-zip-data-provider", dataProviderClass = LargePathologicalZipDataProviderClass.class, timeOut = 200000)
    public void testLargePathologicalMerge(ArrayList<Interval> input, ArrayList<Interval> expected, String label) {
        ArrayList<Interval> results = ZipBstMerge.merge(input);
        Assert.assertEquals(results, expected, label);
    }

    // because of TestNG bug
    @Ignore
    @Test(dataProvider = "huge-zip-data-provider", dataProviderClass = HugeZipDataProviderClass.class, timeOut = 200000)
    public void hugeLargeMerge(ArrayList<Interval> input, ArrayList<Interval> expected, String label) {
        ArrayList<Interval> results = ZipBstMerge.merge(input);
        Assert.assertEquals(results, expected, label);
    }

}
