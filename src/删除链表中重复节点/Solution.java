package 删除链表中重复节点;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public ListNode deleteDuplication(ListNode pHead) {
        if (null == pHead) {
            return pHead;
        } else {
            ListNode newHead = new ListNode(-1);
            ListNode end = newHead;
            return deleteDuplicationHelper(pHead, newHead, end);

        }
    }

    private ListNode deleteDuplicationHelper(ListNode pHead, ListNode newHead, ListNode end) {
        if (pHead == null) {
            return newHead.next;
        } else {
            int count = repeatNum1(pHead, 1);
            if (1 == count) {
                end.next = new ListNode(pHead.val);
                end.next.next = null;
                end = end.next;
                return deleteDuplicationHelper(pHead.next, newHead, end);
            } else {
                for (int i = 0; i < count; i++) {
                    pHead = pHead.next;
                }
                return deleteDuplicationHelper(pHead, newHead, end);
            }
        }
    }

    private int repeatNum1(ListNode pHead, int count) {
        // int res = 1;
        if (pHead == null) {
            return count;
        } else {
            if (pHead.next != null) {
                if (pHead.val == pHead.next.val) {
                    return repeatNum1(pHead.next, count + 1);
                } else {
                    return count;
                }
            } else {
                return count;
            }
        }
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        print(new Solution().deleteDuplication(node1));

    }

    private static void print(ListNode node) {
        if (null == node) {
            return;
        } else {
            System.out.println(node.val);
            print(node.next);
        }
    }
}
