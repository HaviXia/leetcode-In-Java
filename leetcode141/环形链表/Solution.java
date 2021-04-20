package leetcode141.环形链表;


/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */


/*
 *   第一种方法：看！靠眼睛看！
 *       一直往后面推，如果找到了空指针，那就不是环了。。。（硬做） 规定0.5s循环，超过0.5s还没跳出，直接返回有环
 *
 *   第二种：不断的往后走，把节点存在Set中，没到一个新的节点，在Set中查找是否存在？判重 时间复杂度 O(n)
 *
 *   第三种：快、慢指针，快指针每次走两步，慢指针每次走一步；如果没有环，那么快慢指针不会相等；如果快慢指针相遇了，那么就存在环 O(n)
 * */
public class Solution {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
