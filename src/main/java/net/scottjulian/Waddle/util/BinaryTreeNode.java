package net.scottjulian.Waddle.util;


public final class BinaryTreeNode {
    public BinaryTreeNode left;
    public BinaryTreeNode right;
    int value;

    public BinaryTreeNode(BinaryTreeNode l, BinaryTreeNode r, int v){
        left = l;
        right = r;
        value = v;
    }
}
