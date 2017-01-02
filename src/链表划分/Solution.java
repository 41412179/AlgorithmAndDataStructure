package 链表划分;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Solution {
    /**
     * @param head: The first node of linked list.
     * @param x:    an integer
     * @return: a ListNode
     */
    public ListNode partition(ListNode head, int x) {
        // write your code here
        if (null == head) {
            return head;
        }
        if (null == head.next) {
            return head;
        }
        ListNode less = new ListNode(-1), great = new ListNode(-1), next = null, equal = new ListNode(-1);
        ListNode less1 = less, great1 = great, equal_1 = equal;
        while (head != null) {
            if (x < head.val) {
                less.next = head;
            } else {
                if (x == head.val) {
                    equal.next = head;
                } else {
                    great.next = head;
                }
            }
            next = head.next;
            head.next = null;
            head = next;
        }


    }
}
