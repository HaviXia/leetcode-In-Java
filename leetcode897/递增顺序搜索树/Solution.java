package leetcode897.递增顺序搜索树;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author ：hkxia
 * @description：TODO
 * @date ：2021/4/25 22:52
 */
public class Solution {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /*
     *  对输入的二叉搜索树中序遍历，结果保存在列表中
     *   根据列表中节点值，创建只含右节点的二叉搜索树，其过程等驾驭根据节点创建一个链表
     * */
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        inOrder(root, list);

        TreeNode dummyNode = new TreeNode(-1);
        TreeNode currNode = dummyNode;

        for (int i = 0; i < list.size(); i++) {
            int value = list.get(i);
            currNode.right = new TreeNode(value);
            currNode = currNode.right;
        }
        return dummyNode.right;
    }

    public static void inOrder(TreeNode node, List<Integer> resList) {
        if (node == null) {
            return;
        }

        inOrder(node.left, resList);
        resList.add(node.val);
        inOrder(node.right, resList);
    }

    /*
     *   使用栈迭代
     * */
    List<TreeNode> list = new ArrayList<>();

    public TreeNode increasingBST1(TreeNode root) {
        Deque<TreeNode> d = new ArrayDeque<>();
        while (root != null || !d.isEmpty()) {
            while (root != null) {
                d.add(root);
                root = root.left;
            }
            root = d.pollLast();
            list.add(root);
            root = root.right;
        }
        TreeNode dummy = new TreeNode(-1);
        TreeNode cur = dummy;
        for (TreeNode node : list) {
            cur.right = node;
            node.left = null;
            cur = node;
        }
        return dummy.right;
    }
}


