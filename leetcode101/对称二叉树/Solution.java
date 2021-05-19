package leetcode101.对称二叉树;

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

    boolean res = true;

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        dfs(root.left, root.right);
        return res;
    }

    public void dfs(TreeNode left, TreeNode right) {
        if (!res || (left == null && right == null)) return;
        else if (left == null || right == null) {
            res = false;
        } else if (left.val == right.val) {
            dfs(left.left, right.right);
            dfs(left.right, right.left);
        } else {
            res = false;
        }
    }
}
