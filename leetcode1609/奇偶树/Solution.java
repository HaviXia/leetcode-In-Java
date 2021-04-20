package leetcode1609.奇偶树;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

        public boolean isEvenOddTree(TreeNode root) {

            if (root == null) return true;
            /*
             * 递归层序遍历
             * */
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            boolean even = true; // 第一层
            while (queue.size() > 0) {
                int size = queue.size();
                int prevVal = even ? Integer.MIN_VALUE : Integer.MAX_VALUE; //偶数层中全是奇数，并且从小到大
                while (size-- > 0) { // 逐层
                    root = queue.poll();
                    if (even && (root.val % 2 == 0 || root.val <= prevVal))
                        return false; // 偶数层，需要奇数value，并且value是递增，否则false
                    if (!even && (root.val % 2 == 1 || root.val >= prevVal)) return false;
                    prevVal = root.val;
                    if (root.left != null) queue.add(root.left);
                    if (root.right != null) queue.add(root.right);
                }
                even = !even; // alert the level
            }
            return true;
        }
    }
}