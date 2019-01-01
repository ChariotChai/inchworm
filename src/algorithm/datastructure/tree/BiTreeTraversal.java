package algorithm.datastructure.tree;

import java.util.Stack;

/**
 * @author chaiyuze
 * @since 2018/10/1
 */
public class BiTreeTraversal {

    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;
    }

    private static TreeNode constructOneTree() {
        TreeNode root = new TreeNode();
        root.value = 0;

        TreeNode t01 = new TreeNode();
        t01.value = 1;
        root.left = t01;

        TreeNode t02 = new TreeNode();
        t02.value = 2;
        root.right = t02;

        TreeNode t011 = new TreeNode();
        t011.value = 3;
        t01.left = t011;

        TreeNode t012 = new TreeNode();
        t012.value = 4;
        t01.right = t012;

        TreeNode t022 = new TreeNode();
        t022.value = 5;
        t02.right = t022;

        return root;
    }

    public static void preOrderTraversalRecurrent(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.value + ",");

        if (root.left != null) {
            preOrderTraversalRecurrent(root.left);
        }
        if (root.right != null) {
            preOrderTraversalRecurrent(root.right);
        }
    }

    /**
     * easiest case
     * @param root
     */
    public static void preOrderTraversalLoop(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        s.push(root);

        TreeNode current;
        while (!s.isEmpty()) {
            current = s.pop();
            System.out.print(current.value + ",");

            if (current.right != null) {
                s.push(current.right);
            }

            if (current.left != null) {
                s.push(current.left);
            }
        }
    }

    public static void midOrderTraversalRecurrent(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            midOrderTraversalRecurrent(root.left);
        }
        System.out.print(root.value + ",");
        if (root.right != null) {
            midOrderTraversalRecurrent(root.right);
        }
    }

    /**
     * a little tough, not alike pre-order case
     * @param root
     */
    public static void midOrderTraversalLoop(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        TreeNode current = root;
        while (current != null || !s.isEmpty()) {

            if (current != null) {
                s.push(current);
                current = current.left;
            } else {
                current = s.pop();
                System.out.print(current.value + ",");
                current = current.right;
            }

        }
    }

    public static void postOrderTraversalRecurrent(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            postOrderTraversalRecurrent(root.left);
        }
        if (root.right != null) {
            postOrderTraversalRecurrent(root.right);
        }
        System.out.print(root.value + ",");
    }

    public static void postOrderTraversalLoop(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        TreeNode current = root;

        while (!s.isEmpty()) {

            if (current.right != null) {
                s.push(current);
            }

            if (current.left != null) {
                current = current.left;
            }

            else {
                current = s.pop();
                System.out.print(current.value + ",");
                current = current.right;
            }

        }
    }

    public static int nodeNumRecurrent(TreeNode root) {
        return root == null ?
                0 :
                1 + nodeNumRecurrent(root.left) + nodeNumRecurrent(root.right);
    }

//    public static int nodeNumLoop(TreeNode root) {
//
//    }

    public static int depthRecurrent(TreeNode root) {
        return root == null ?
                0 :
                Math.max(depthRecurrent(root.left), depthRecurrent(root.right)) + 1;
    }

//    public static int depthLoop(TreeNode root) {
//
//    }

    public static int leafNumRecurrent(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 1;
        } else {
            return leafNumRecurrent(root.left) + leafNumRecurrent(root.right);
        }
    }

//    public static int leafNumLoop(TreeNode root) {
//
//    }

    public static void main(String[] args) {
        TreeNode t1 = constructOneTree();
//        preOrderTraversalRecurrent(t1);
//        System.out.println("");
//        preOrderTraversalLoop(t1);
//        System.out.println("");
//        midOrderTraversalRecurrent(t1);
//        System.out.println("");
//        midOrderTraversalLoop(t1);
//        System.out.println("");
        postOrderTraversalRecurrent(t1);
    }

}
