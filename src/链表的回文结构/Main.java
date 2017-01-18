package 链表的回文结构;

import java.io.BufferedInputStream;
import java.util.Scanner;

import static jdk.nashorn.internal.objects.NativeArray.reverse;

/**
 * Created by h on 16-12-28.
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Main {
    public boolean chkPalindrome(ListNode A) {
        ListNode fast = A, slow = A;
        if (A.next == null) return true;
        else fast = fast.next;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode middle = null;
        if (fast.next != null) {
            middle = reverseList(slow.next.next);
        } else {
            middle = reverseList(slow.next);
        }
        ListNode one = A, two = middle;
        boolean flag = false;
        while (one != null && two != null) {
            if (one.val != two.val) {
                flag = true;
                break;
            }
            one = one.next;
            two = two.next;
        }
        reverseList(middle);
        //printList(A);
        if (flag) {
            return false;
        } else {
            return true;
        }
    }

    private void printList(ListNode head) {
        if (head == null) {
            return;
        }
        System.out.println(head.val);
        printList(head.next);
    }

    private ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode pre = null, cur = head, next = head.next;
        while (next != null) {
            cur.next = pre;
            pre = cur;
            cur = next;
            next = cur.next;
            cur.next = pre;
        }
        return cur;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        ListNode head = new ListNode(1);
        ListNode one = new ListNode(2);
        ListNode two = new ListNode(3);
        ListNode three = new ListNode(2);
        ListNode four = new ListNode(1);
        head.next = one;
        one.next = two;
        two.next = three;
        three.next = four;
        //new Main().printList(new Main().reverseList(head));
        System.out.println(new Main().chkPalindrome(head));
        in.close();
    }
}
