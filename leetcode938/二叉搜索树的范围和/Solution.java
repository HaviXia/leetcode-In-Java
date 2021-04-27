package leetcode938.二叉搜索树的范围和;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ：hkxia
 * @description：TODO
 * @date ：2021/4/27 22:53
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


    //方案1 DFS  时间复杂度 ON  空间复杂度 ON
    /*
     *  root == null return 0;
     *  root.val > high , 从二叉树的左节点开始递归找，找到范围和
     *  root.val < low  , 从二叉树的右节点开始递归找，找到范围和
     *  low < root.val < high , 此时应返回 root 节点的值、左子树的范围和、右子树的范围和这三者之和
     * */
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        if (root.val > high) return rangeSumBST(root.left, low, high);
        if (root.val < low) return rangeSumBST(root.right, low, high);

        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }

    //方案2 BFS  时间复杂度 ON  空间复杂度 ON
    /*
     *  使用广度优先，使用队列保存入队的节点，当节点要出队时，将节点的左右添加
     * */
    public int rangeSumBST1(TreeNode root, int low, int high) {
        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode tmpNode = queue.poll(); // 删除队首节点，把该节点的孩子添加
            if (tmpNode == null) {
                continue;
            }
            if (tmpNode.val > high) {
                queue.offer(tmpNode.left);
            } else if (tmpNode.val < low) {
                queue.offer(tmpNode.right);
            } else {
                res += tmpNode.val;
                queue.offer(tmpNode.left);
                queue.offer(tmpNode.right);
            }
        }
        return res;
    }
}
