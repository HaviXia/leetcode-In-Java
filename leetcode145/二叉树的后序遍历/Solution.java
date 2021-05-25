package leetcode145.二叉树的后序遍历;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {
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

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        if (root == null) return resList;
        postOrder(root, resList);
        return resList;
    }

    public void postOrder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        postOrder(root.left, list);
        postOrder(root.right, list);
        list.add(root.val);
    }

    // 迭代
    public List<Integer> postorderTraversal1(TreeNode root) {

        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        List<Integer> resList = new ArrayList<>();

        if (root == null) return resList;

        TreeNode node = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == node) { // 一定没有左子树了
                resList.add(root.val);
                node = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return resList;
    }
}
