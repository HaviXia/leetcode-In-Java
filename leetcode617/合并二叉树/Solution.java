package leetcode617.合并二叉树;

/**
 * @author ：hkxia
 * @description：TODO
 * @date ：2021/4/20 09:32
 */

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
    /*
    *  DFS:
    *
    * */

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        TreeNode resNode = new TreeNode();

        while (root1 != null || root2 != null) {

        }
    }
}