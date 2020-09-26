
The ZipMerge::merge method is the only one completely implemented and passing tests.

Yes, the code is modeled after the references. I believe the "best line of code is the one not written" an paraphase of Steve Jobs amoung others.
There are other IntervalTree implementations that could be explored.  The tests are designed to make it easy to test other implementations.  Specificaly, the ZipIntervalTreeMerge is not finished.

Input requirements:
 - The Intervals have to be in proper order, ie [lower, higher]
 - TestMG fails on very large sets of Intervals
 
References:
- https://stackoverflow.com/questions/31670849/merge-overlapping-intervals
- https://en.wikipedia.org/wiki/Interval_tree
- https://www.includehelp.com/data-structure-tutorial/interval-tree.aspx
- https://www.tutorialcup.com/interview/tree/interval-tree.htm
- https://www.geeksforgeeks.org/merging-intervals/
- https://en.wikipedia.org/wiki/Pairing_heap

Todo:
- tests that have more and random merges.

Problems:
- The BST impl is having trouble with large interval sets that do not merge.
- There is a TestNG problem with the BST Huge test
- There are gradle warnings about features used not being compatible with gradle 7.0

