package 剑指Offer28.对称的二叉树;

import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 递归
    public boolean isSymmetric(TreeNode root) {
        return root == null ? true : recur(root.left, root.right);
    }

    boolean recur(TreeNode L, TreeNode R) {
        if (L == null && R == null) return true;
        if (L == null || R == null || L.val != R.val) return false;
        return recur(L.left, R.right) && recur(L.right, R.left);
    }

    // 迭代
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) return true;
        LinkedList<TreeNode> q1 = new LinkedList<>();
        LinkedList<TreeNode> q2 = new LinkedList<>();
        q1.addLast(root.left);
        q2.addLast(root.right);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode n1 = q1.removeLast();
            TreeNode n2 = q2.removeLast();
            if (n1 == null && n2 == null)
                continue;
            if (n1 == null || n2 == null || n1.val != n2.val)
                return false;
            q1.addLast(n1.left);
            q1.addLast(n1.right);
            q2.addLast(n2.right);
            q2.addLast(n2.left);
        }
        return true;
    }
}