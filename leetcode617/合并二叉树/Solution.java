package leetcode617.合并二叉树;



import java.util.LinkedList;

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
     *       两个二叉树节点都空，那么合并之后的节点也是空；
     *       两个节点只有一个为空，那么合并后的二叉树的对应节点为非空的节点；
     *       二叉树的对应节点都不空，合并后的二叉树对应节点的值为两个 val 的和
     * */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        TreeNode resMergedTree = new TreeNode(root1.val + root2.val);

        resMergedTree.left = mergeTrees(root1.left, root2.left);
        resMergedTree.right = mergeTrees(root1.right, root2.right);

        return resMergedTree;
    }

    /*
     *  BFS:
     *       首先计算合并后的根节点的值，然后从合并后的二叉树与两个原始二叉树的根节点开始广度优先搜索
     *       从根节点开始同时遍历每个二叉树，并将对应的节点进行合并
     *
     * */


    /*
     *  递归
     *      终止条件：树 1 的节点为 null，或者树 2 的节点为 null
     *      递归函数内：将两个树的节点相加后，再赋给树 1 的节点。
     *      再递归的执行两个树的左节点，递归执行两个树的右节点
     **/
    public TreeNode mergeTrees2(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        return dfs(root1, root2);
    }

    public static TreeNode dfs(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        root1.val += root2.val; //合并val结果放到root1上
        root1.left = dfs(root1.left, root2.left);
        root1.right = dfs(root1.right, root2.right);
        return root1;
    }

    /*
     *   迭代：BFS
     *       广度优先就需要额外的数据结构来辅助了，借助栈或者队列来完成
     *       两棵树的左节点不空，将两个节点放入 queue ；右节点同理...
     *       不断从 queue 中 poll()，将取出来的节点 val 相加
     *
     *      注意：root1.left == null && root2.left != null 直接将 root2.left 赋值给 root1.left；同理 right 节点
     * */
    public TreeNode mergeTrees3(TreeNode t1, TreeNode t2) {
        //如果 t1和t2中，只要有一个是null，函数就直接返回
        if (t1 == null || t2 == null) {
            return t1 == null ? t2 : t1;
        }
        LinkedList<TreeNode> queue = new java.util.LinkedList<TreeNode>();
        queue.add(t1);
        queue.add(t2);
        while (queue.size() > 0) {
            TreeNode r1 = queue.remove();
            TreeNode r2 = queue.remove();
            r1.val += r2.val;
            //如果r1和r2的左子树都不为空，就放到队列中
            //如果r1的左子树为空，就把r2的左子树挂到r1的左子树上
            if (r1.left != null && r2.left != null) {
                queue.add(r1.left);
                queue.add(r2.left);
            } else if (r1.left == null) {
                r1.left = r2.left;
            }
            //对于右子树也是一样的
            if (r1.right != null && r2.right != null) {
                queue.add(r1.right);
                queue.add(r2.right);
            } else if (r1.right == null) {
                r1.right = r2.right;
            }
        }
        return t1;
    }
}