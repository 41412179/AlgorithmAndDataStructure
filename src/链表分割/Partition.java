package 链表分割;

import java.util.*;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Partition {

    public ListNode partition(ListNode head, int x) {
        ListNode pHead = new ListNode(-1);
        ListNode pHead2 = new ListNode(-2);
        // first list
        ListNode firstHead = pHead;
        ListNode firstTail = pHead;
        // second list
        ListNode secondTail = pHead2;
        ListNode secondHead = pHead2;
        //
        ListNode traverse = head;
        while (traverse != null) {
            int val = traverse.val;
            if (val < x) {
                firstTail.next = traverse;
                firstTail = firstTail.next;
                traverse = traverse.next;
                firstTail.next = null;
            } else {
                if (val >= x) {
                    secondTail.next = traverse;
                    secondTail = secondTail.next;
                    traverse = traverse.next;
                    secondTail.next = null;
                }
            }
        }
        firstTail.next = secondHead.next;
        return firstHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(3);
        ListNode head3 = new ListNode(4);
        ListNode head4 = new ListNode(5);
        ListNode head5 = new ListNode(6);
        head.next = head5;
        head5.next = head1;
        head1.next = head4;
        head4.next = head2;
        head2.next = head3;
        print(new Partition().partition(head, 3));
    }

    private static void print(ListNode head) {
        if (head == null) {
            return;
        } else {
            System.out.print(head.val + " ");
            print(head.next);
        }
    }
}
