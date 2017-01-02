package 翻转链表;

// Definition for ListNode.
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
     * @param head: The head of linked list.
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        // write your code here
        if (head == null) {
            return head;
        }
        ListNode pre = null, next = null;
        while (true) {
            if (head != null) {
                next = head.next;
                head.next = pre;
                pre = head;
                head = next;
            } else {
                break;
            }
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);

        ListNode one = new ListNode(2);
        ListNode two = new ListNode(3);
        root.next = one;
        one.next = two;
        print(new Solution().reverse(root));
    }

    private static void print(ListNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val + " ");
        print(root.next);
    }
}
