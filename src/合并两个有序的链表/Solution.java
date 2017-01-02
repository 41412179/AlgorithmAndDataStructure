package 合并两个有序的链表;


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode acc = new ListNode(-1);
        ListNode end = acc;
        return MergeHelper(list1, list2, acc, end);
    }

    private ListNode MergeHelper(ListNode list1, ListNode list2, ListNode acc, ListNode end) {
        //return null;
        if (list1 == null) {
            end.next = list2;
            return acc.next;
        }
        if (list2 == null) {
            end.next = list1;
            return acc.next;
        }

        if (list1.val < list2.val) {
            end.next = new ListNode(list1.val);
            end = end.next;
            return MergeHelper(list1.next, list2, acc, end);
        } else {
            end.next = new ListNode(list2.val);
            end = end.next;
            return MergeHelper(list1, list2.next, acc, end);
        }
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(2);
        ListNode list3 = new ListNode(3);
        ListNode list4 = new ListNode(4);
        ListNode list5 = new ListNode(5);
        list1.next = list2;
        list2.next = list3;
        list3.next = list4;
        list4.next = list5;

        ListNode list6 = new ListNode(1);
        ListNode list7 = new ListNode(2);
        ListNode list8 = new ListNode(3);
        ListNode list9 = new ListNode(4);
        ListNode list10 = new ListNode(5);
        list6.next = list7;
        list7.next = list8;
        list8.next = list9;
        list9.next = list10;
        print(new Solution().Merge(list1, list6));

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
