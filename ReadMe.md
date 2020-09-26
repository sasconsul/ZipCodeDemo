


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

Problems:
- The BST impl is having trouble with large interval sets that do not merge.
- There is a TestNG problem with the BST Huge test
- There are gradle warnings about features used not being compatible with gradle 7.0
