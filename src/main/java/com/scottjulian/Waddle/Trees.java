package com.scottjulian.Waddle;

import com.scottjulian.Waddle.util.node.BinaryTreeNode;

public final class Trees {

    /**
     *
     * https://leetcode.com/problems/count-complete-tree-nodes/
     *
     * O(Log(n)^2)
     *
     * @param root
     * @return
     */
    public static int countCompleteBinaryTreeNodes(BinaryTreeNode root){
        if(root == null){
            return 0;
        }

        int leftHeight = getCBTLeftHeight(root);
        int rightHeight = getCBTLeftHeight(root.right);

        if(rightHeight == leftHeight - 1) {
            return (1 << leftHeight) + countCompleteBinaryTreeNodes(root.right);
        }
        else {
            return (1 << leftHeight - 1) + countCompleteBinaryTreeNodes(root.left);
        }
    }

    private static int getCBTLeftHeight(BinaryTreeNode root) {
        if(root == null) {
            return -1;
        }
        return getCBTLeftHeight(root.left) + 1;
    }


    /**
     *
     * https://leetcode.com/problems/invert-binary-tree/
     *
     * @param root
     * @return
     */
    public static BinaryTreeNode invertBinaryTree(BinaryTreeNode root) {
        if(root == null){
            return null;
        }
        BinaryTreeNode tmpRight = root.right;
        root.right = invertBinaryTree(root.left);
        root.left = invertBinaryTree(tmpRight);
        return root;
    }


}

