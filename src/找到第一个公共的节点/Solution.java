package 找到第一个公共的节点;

import java.util.HashMap;


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {
    HashMap<ListNode, Integer> hms = new HashMap<ListNode, Integer>();

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        traverse(pHead1);
        return traverse(pHead2);
    }

    private ListNode traverse(ListNode pHead) {
        if (pHead == null) {
            return null;
        } else {
            if (hms.containsKey(pHead)) {
                return pHead;
            } else {
                hms.put(pHead, 1);
                return traverse(pHead.next);
            }
        }
    }

    private static void print(ListNode node) {
        if (null == node) {
            return;
        } else {
            System.out.println(node.val);
            print(node.next);
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
        print(new Solution().FindFirstCommonNode(list1, list1));

    }

}