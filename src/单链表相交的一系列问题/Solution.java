package 单链表相交的一系列问题;

/**
 * Created by h on 16-12-24.
 */

//  Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = hitNode(head);
        if (slow == null) {//如果没有环
            return null;
        } else {
            ListNode fast = head;
            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
                if (fast == slow) {
                    return fast;
                }
            }
        }
        return slow;
    }

    public ListNode hitNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head, slow = head;
        while (true) {
            if (fast.next != null) {
                if (fast.next.next != null) {
                    fast = fast.next.next;
                    slow = slow.next;
                    if (fast == slow) {
                        return slow;
                    }
                } else {
                    return null;
                }
            } else {
                return null;
            }
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head, slow = head;
        while (true) {
            if (fast.next != null) {
                if (fast.next.next != null) {
                    fast = fast.next.next;
                    if (fast == slow) {
                        return true;
                    }
                    slow = slow.next;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = three;

        System.out.println(new Solution().detectCycle(one).val);
        one = null;
        two = null;
        three = null;
    }
}