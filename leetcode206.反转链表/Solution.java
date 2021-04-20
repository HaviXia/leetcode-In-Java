package leetcode206.反转链表;


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

public class Solution {
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

    public ListNode reverseList(ListNode head) {
        // 需要两个指针，一个指针指向当前节点，另外一个指针指向当前节点的前一个节点
        // 把当前节点的 next 指向前一个节点
        ListNode prevNode, currNode;
        prevNode = null;
        currNode = head;
        while (currNode != null) { // 直到循环到链表结束
            ListNode tmpNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = tmpNode;
        }
        return prevNode;
    }
}

