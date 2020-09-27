package net.sasconsul;

import java.util.ArrayList;

public class IntervalNode {
    public int start;
    public int end;
    public IntervalNode left;
    public IntervalNode right;

    public IntervalNode(Interval interval) {
        this.start = interval.start;
        this.end = interval.end;
    }

    public IntervalNode(Interval interval, IntervalNode left, IntervalNode right) {
        this.start = interval.start;
        this.end = interval.end;
        this.left = left;
        this.right = right;
    }

    public static IntervalNode add( IntervalNode root, Interval interval) {
        return add(root, new IntervalNode(interval));
    }

    public static IntervalNode add(IntervalNode root, IntervalNode x){
        if(root == null)
            return x;
        if(root.start >= x.start){
            root.left = add(root.left,x);
            if(mergeLeft(root,root.left)){
                root.left = null;
            }
        }
        else{
            root.right = add(root.right,x);
            if(mergeRight(root,root.right)){
                root.right = null;
            }
        }

        return root;
    }

    private static boolean mergeLeft(IntervalNode root,IntervalNode left){
        if(left.end < root.start)
            return false;

        else{
            root.start = Math.min(root.start, left.start);
            root.end = Math.max(root.end, left.end);
            return true;
        }
    }

    private static boolean mergeRight(IntervalNode root,IntervalNode right){
        if(right.start > root.end)
            return false;
        else{
            root.start = Math.min(root.start, right.start);
            root.end = Math.max(root.end, right.end);
            return true;
        }
    }

    /**
     *    Flatten the tree into an ArrayList via in order traversal
     *    Usage: pass an empty ArrayList<Interval>
     *
     * @param ans
     * @param node
     * @return the flattened data
     */
    public static ArrayList<Interval> toArrayListRecurse(ArrayList<Interval> ans, IntervalNode node) {
        if (node == null) {
            return ans;
        } else {
            ans.add(new Interval(node.start, node.end));
        }
        toArrayListRecurse(ans, node.left);
        toArrayListRecurse(ans, node.right);
        return ans;
    }


    /**
     * Flatten the tree into an ArrayList via in order traversal
     * Usage: pass an empty ArrayList<Interval>
     *
     * @param ans
     * @param node
     * @return the flattened data
     */
    public static ArrayList<Interval> toArrayListLoop(ArrayList<Interval> ans, IntervalNode node) {
        if (node == null) {
            return ans;
        } else {
            ans.add(new Interval(node.start, node.end));
        }
        toArrayListRecurse(ans, node.left);
        toArrayListRecurse(ans, node.right);
        return ans;
    }

}
