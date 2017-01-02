package 链式APlusB;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Plus {

    public static void main(String[] args) {
        ListNode one = new ListNode(9);
        ListNode two = new ListNode(3);
        ListNode three = new ListNode(7);
        ListNode four = new ListNode(6);
        ListNode five = new ListNode(3);
        one.next = two;
        two.next = three;
        four.next = five;
        //print(new Plus().reverse(one));
        new Plus().plusAB(one, four);
    }

    private static void print(ListNode root) {
        if (root == null)
            return;
        System.out.print(root.val + " ");
        print(root.next);
    }

    public ListNode plusAB(ListNode a, ListNode b) {
        // write code here
        a = reverse(a);
        b = reverse(b);
        ListNode ans = null;
        ListNode aHead = a;
        ListNode bHead = b;
        int add = 0;
        while (a != null || b != null) {
            int val = 0;
            val += add;
            if (a != null) {
                val += a.val;
                a = a.next;
            }
            if (b != null) {
                val += b.val;
                b = b.next;
            }
            if (val > 9) {
                add = val / 10;
                val %= 10;

                if (ans == null) {
                    ans = new ListNode(val);
                } else {
                    ListNode tmp = ans;
                    ans = new ListNode(val);
                    ans.next = tmp;
                }
            } else {
                add = 0;
                if (ans == null) {
                    ans = new ListNode(val);
                } else {
                    ListNode tmp = ans;
                    ans = new ListNode(val);
                    ans.next = tmp;
                }
            }
        }
        if (add != 0) {
            ListNode tmp = ans;
            ans = new ListNode(add);
            ans.next = tmp;
        }
        aHead = reverse(aHead);
        bHead = reverse(bHead);
        print(ans);
        print(aHead);
        return ans;
    }

    private ListNode reverse(ListNode a) {
        ListNode pre = null;
        ListNode next = null;
        ListNode cur = a;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

}
