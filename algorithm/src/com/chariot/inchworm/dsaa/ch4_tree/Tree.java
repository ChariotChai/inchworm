package com.chariot.inchworm.dsaa.ch4_tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 一棵普通的树
 * @author chaiyuze
 */
public class Tree {

    static class TreeNode {
        int e; //节点值
        List<TreeNode> childs; //子节点

        TreeNode(int e) {
            this.e = e;
        }

        void addChild(TreeNode... node) {
            if (childs == null) {
                childs = new LinkedList<>();
            }

            for (TreeNode n: node) {
                childs.add(n);
            }
        }

        /**
         * 表示被访问
         */
        void walk() {
            System.out.print(e + " ");
        }
    }

    /**
     * 先序遍历(递归)
     * 当前节点 -> 所有子节点
     */
    public static void preOrderTraversalRec(TreeNode root) {
        //递归终止条件
        if (root == null) {
            return;
        }

        //首先访问当前节点
        root.walk();

        //遍历访问其子节点
        if (root.childs != null) {
            for (TreeNode node: root.childs) {
                preOrderTraversalRec(node);
            }
        }
    }

    /**
     * 先序遍历(非递归)
     * @param root
     */
    public static void preOrderTraversalNonRec(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> nodes = new Stack<>();
        nodes.push(root);

        while (!nodes.isEmpty()) {
            //首先取出栈中头节点并访问
            TreeNode node = nodes.pop();
            node.walk();

            //然后将头结点的所有子节点压栈(注意这里需要反序入栈)
            if (node.childs != null) {
                for (int i = node.childs.size(); i > 0; i--) {
                    nodes.push(node.childs.get(i - 1));
                }
            }
        }
    }

    /**
     * 后序遍历(递归)
     * 所有子节点 -> 当前节点
     * @param root
     */
    public static void postOrderTraversalRec(TreeNode root) {
        //递归终止条件
        if (root == null) {
            return;
        }

        //遍历访问其子节点
        if (root.childs != null) {
            for (TreeNode node: root.childs) {
                postOrderTraversalRec(node);
            }
        }

        //然后访问当前节点
        root.walk();
    }

    /**
     * 后序遍历(非递归)
     * 有一定的难度
     * 这里采用入栈2次的技巧(否则需要维护节点的被访问状态，用入栈2次可以巧妙地表示节点的被访问状态)
     * @param root
     */
    public static void postOrderTraversalNonRec(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> nodes = new Stack<>();
        nodes.push(root);
        nodes.push(root);

        while (!nodes.isEmpty()) {
            //取出头结点，与下一个头结点(不取出)比较
            TreeNode node = nodes.pop();
            if (!nodes.isEmpty()) {
                TreeNode nextNode = nodes.peek();

                //下一个节点与当前节点相同，说明当前需要访问该节点的子节点
                if (node == nextNode) {
                    if (node.childs != null) {
                        //注意这里倒序入栈，且每个节点压入两遍
                        for (int i = node.childs.size(); i > 0; i--) {
                            nodes.push(node.childs.get(i - 1));
                            nodes.push(node.childs.get(i - 1));
                        }
                    }
                }

                //否则说明该节点的子节点已经处理过，现在需要访问当前节点
                else {
                    node.walk();
                }
            }

            //栈中如不存在节点，则当前节点是最初压入的根节点，且其子节点已经处理过，现在仅需要访问
            else {
                node.walk();
            }
        }
    }

    /**
     * 层次遍历
     * bfs
     * @param root
     */
    public static void levelTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        //使用队列实现bfs
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);

        while (!nodes.isEmpty()) {
            //访问当前节点
            TreeNode node = nodes.poll();
            node.walk();

            //将当前节点的子节点加入队列
            if (node.childs != null) {
                for (TreeNode n: node.childs) {
                    nodes.offer(n);
                }
            }
        }
    }

    /**
     * 计算节点的深度(根到节点的路径长)
     * @param root
     * @param target
     * @return
     */
    public static int nodeDepth(TreeNode root, TreeNode target) {
        if (root == null) {
            return -1;
        }

        //进行bfs(层次遍历)，寻找节点
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        int depth = 0;

        while (!nodes.isEmpty()) {

            //当前队列为同一层的节点，由于下一层子节点会入队，这里一次处理一层
            int levelNodeCnt = nodes.size();
            for (int i = 0; i < levelNodeCnt; i++) {
                //访问当前节点
                TreeNode node = nodes.poll();
                if (node == target) {
                    return depth;
                }

                //将当前节点的子节点加入队列
                if (node.childs != null) {
                    for (TreeNode n: node.childs) {
                        nodes.offer(n);
                    }
                }
            }

            //本层未找到，深度+1
            depth++;
        }

        //树中未找到节点
        return -1;
    }

    /**
     * 计算节点的高度(节点到其叶节点最长路径的长)
     * 树的高度即为其根节点的高度
     * @param node
     * @return
     */
    public static int nodeHeight(TreeNode node) {
        if (node == null) {
            return -1;
        }

        Stack<TreeNode> nodes = new Stack<>();
        nodes.push(node);

        int height = 0;
        while (!nodes.isEmpty()) {
            TreeNode curNode = nodes.pop();
            if (curNode.childs != null) {
                for (TreeNode n: curNode.childs) {
                    nodes.push(n);
                }
            } else {
//todo
            }
        }

        return height;
    }

    /**
     * 计算树中节点的个数(递归)
     * @param root
     * @return
     */
    public static int nodeAmountRec(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int cnt = 1;
        if (root.childs != null){
            for (TreeNode n: root.childs) {
                cnt += nodeAmountRec(n);
            }
        }

        return cnt;
    }

    /**
     * 计算树中叶节点的个数(递归)
     * @param root
     * @return
     */
    public static int leafNodeAmountRec(TreeNode root) {
        if (root == null) {
            return 0;
        }

        //为叶节点，递归终止
        if (root.childs == null) {
            return 1;
        }

        //不为叶节点，其叶节点数等于各子树的叶节点数之和
        int cnt = 0;
        for (TreeNode n: root.childs) {
            cnt += leafNodeAmountRec(n);
        }
        return cnt;
    }

    /**
     * 寻找两个节点的首个公共祖先节点
     * @return
     */
    public static TreeNode findFirstAncestor(TreeNode root, TreeNode n1, TreeNode n2) {
        return null;
    }

    /**
     * 打印一棵树
     * @param root
     */
    public static void printTree(TreeNode root) {

        class TreeRow {
        }

    }

    public static void main(String[] args) {
        //构造一棵树
        TreeNode root = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        node4.addChild(node5, node6, node7);
        node2.addChild(node3, node4);
        node1.addChild(node8);
        root.addChild(node1, node2);

        //打印树
        printTree(root);

        //先序遍历
        System.out.println("================= pre-order traversal ==================");
        preOrderTraversalRec(root);
        System.out.println();
        preOrderTraversalNonRec(root);
        System.out.println();

        //后序遍历
        System.out.println("================= post-order traversal ==================");
        postOrderTraversalRec(root);
        System.out.println();
        postOrderTraversalNonRec(root);
        System.out.println();

        //层次遍历
        System.out.println("================= level traversal ==================");
        levelTraversal(root);
        System.out.println();

        //计算节点的深度
        System.out.println("================= node depth ==================");
        System.out.println(nodeDepth(root, node8));
        System.out.println(nodeDepth(root, node7));

        //计算节点的高度
        System.out.println("================= node height ==================");
        System.out.println(nodeHeight(node1));
        System.out.println(nodeHeight(node2));
        System.out.println(nodeHeight(root));

        //计算节点个数
        System.out.println("================= node amount ==================");
        System.out.println(nodeAmountRec(root));

        //计算叶节点个数
        System.out.println("================= leaf amount ==================");
        System.out.println(leafNodeAmountRec(root));

    }

}
