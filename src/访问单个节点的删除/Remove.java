package 访问单个节点的删除;

import java.util.*;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Remove {

    public boolean removeNode(ListNode pNode) {
        // write code here
        if (pNode.next == null || pNode == null) {
            return false;
        }

        pNode.val = pNode.next.val;
        pNode.next = pNode.next.next;
        return true;
    }

    public static void main(String[] args) {

    }

}
