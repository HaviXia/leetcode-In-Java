package leetcode144.二叉树的前序遍历;

import com.sun.scenario.effect.Brightpass;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

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
class Solution {
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
        List<Integer> resList = new ArrayList<Integer>();
        preOrder(root, resList);
        return resList;
    }

    public void preOrder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }

    // 迭代
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        if (root == null) return resList;

        Deque<TreeNode> stack = new LinkedList<TreeNode>();

        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                resList.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return resList;
    }

}
