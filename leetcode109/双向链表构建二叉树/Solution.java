package leetcode109.双向链表构建二叉树;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
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

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

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
     *  升序链表，需要找到中间节点 root, 左子树的根root 也是 left 到 中间节点 的中间节点; 右子树的根root 也是 中间节点 到 right 的中间节点;
     *
     * */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;

        if (head.next == null) return new TreeNode(head.val);

        //返回高度平衡的二叉树
        ListNode fast = head, slow = head; // 快慢节点找中间节点
        //增加 prev 指针，目的是斩断之后递归中 fast 到 中间节点 的链表，防止 fast` 指针运动超过上一次的 中间节点
        ListNode prev = null;
        while (fast != null && fast.next != null) { // fast 走两步、 slow 走一步；slow 停止的节点就是中间节点
            fast = fast.next.next;
            prev = slow; // prev 就是 slow 链表前一个节点
            slow = slow.next;
        }
        prev.next = null;
        // 得到 中间节点
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head); // sortedListToBST 得到高度平衡的二叉树
        root.right = sortedListToBST(slow.next);

        slow.next = null; // 这个是为了切断 中间节点 右侧的链表递归
        return root;
    }
}