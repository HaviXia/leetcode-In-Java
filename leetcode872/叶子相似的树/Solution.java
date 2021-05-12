package leetcode872.叶子相似的树;


import java.util.*;

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

    // DFS
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> resList1 = new ArrayList<Integer>();

        if (root1 != null) {
            dfs(root1, resList1);
        }
        List<Integer> resList2 = new ArrayList<Integer>();

        if (root2 != null) {
            dfs(root2, resList2);
        }

        return resList1.equals(resList2);
    }

    public void dfs(TreeNode root, List<Integer> list) {
        if (root.left == null && root.right == null) {
            list.add(root.val);
        } else {
            if (root.left != null) {
                dfs(root.left, list);
            }
            if (root.right != null) {
                dfs(root.right, list);
            }
        }
    }

    // BFS
    public boolean leafSimilar1(TreeNode t1, TreeNode t2) {
        List<Integer> l1 = new ArrayList<>(), l2 = new ArrayList<>();
        process(t1, l1);
        process(t2, l2);
        if (l1.size() == l2.size()) {
            for (int i = 0; i < l1.size(); i++) {
                if (!l1.get(i).equals(l2.get(i))) return false;
            }
            return true;
        }
        return false;
    }

    void process(TreeNode root, List<Integer> list) {
        Deque<TreeNode> d = new ArrayDeque<>();
        while (root != null || !d.isEmpty()) {
            while (root != null) {
                d.addLast(root);
                root = root.left;
            }
            root = d.pollLast();
            if (root.left == null && root.right == null) list.add(root.val);
            root = root.right;
        }
    }

    /*
    *   使用两个栈分别记录两棵树其出发搜寻叶子节点的起始点.
        只要有任意一个栈为空，说明其树以经遍历完毕。这里有两种情况:
        两个栈都空了，并且叶子节点都相等，因此返回true
        只有一颗树空了，证明另一棵树一定还有别的叶子节点, 因此返回false
        分别取出两个栈栈顶节点作为本次的起始点，并出发找到其对于的叶子节点。
        左孩子不为空时，如果右孩子也不为空，则将其推入栈作为起始点。然后继续往左搜寻叶子节点。
        左孩子为空时，那么右孩子一定不为空，则出发往右孩子寻找第一个叶子节点。
        当两棵树分别都找到叶子节点后，比较它们的值是否相等，如果不相等则返回false, 相等则继续取栈顶节点作为新的起始点。
    * */
    public boolean leafSimilar2(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> stack1 = new Stack();
        Stack<TreeNode> stack2 = new Stack();
        stack1.push(root1);
        stack2.push(root2);
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            TreeNode root = stack1.pop();
            while (root.left != null || root.right != null) {
                if (root.left != null) {
                    if (root.right != null) stack1.push(root.right);
                    root = root.left;
                } else {
                    if (root.right != null) root = root.right;
                }
            }
            TreeNode root3 = stack2.pop();
            while (root3.left != null || root3.right != null) {
                if (root3.left != null) {
                    if (root3.right != null) stack2.push(root3.right);
                    root3 = root3.left;
                } else {
                    if (root3.right != null) root3 = root3.right;
                }
            }
            if (root.val != root3.val) return false;
        }
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
