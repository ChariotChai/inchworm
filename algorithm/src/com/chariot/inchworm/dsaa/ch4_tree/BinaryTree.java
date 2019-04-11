package com.chariot.inchworm.dsaa.ch4_tree;

/**
 * 二叉树
 * @author chaiyuze
 */
public class BinaryTree {

    /**
     * 二叉树的节点由左子树、右子树、节点值组成
     */
    static class TreeNode {
        int e;
        TreeNode left;
        TreeNode right;

        void walk() {
            System.out.println(e + " ");
        }
    }

    /**
     * 中序遍历(递归)
     * @param root
     */
    public void midTraversalRec(TreeNode root) {
        if (root == null) {
            return;
        }
        midTraversalRec(root.left);
        root.walk();
        midTraversalRec(root.right);
    }

    /**
     * 中序遍历(非递归)
     * @param root
     */
    public void midTraversalNonRec(TreeNode root) {

    }

}

