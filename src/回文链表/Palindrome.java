package 回文链表;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Palindrome {
    public boolean isPalindrome(ListNode pHead) {
        // get middle node pointer
        ListNode head = new ListNode(-1);
        head.next = pHead;
        ListNode rightStart = head;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            if (p != null) {
                p = p.next;
                rightStart = rightStart.next;
            }
        }

        rightStart = traverse(rightStart);
        ListNode middle = rightStart;
        ListNode leftStart = pHead;
        //判断链表是否是回文的
        while (true) {
            if (leftStart != null) {
                if (leftStart.val == rightStart.val) {
                    leftStart = leftStart.next;
                    rightStart = rightStart.next;
                    continue;
                } else {
                    traverse(middle);
                    return false;
                }
            } else {
                rightStart = traverse(middle);
                print(pHead);
                return true;
            }
        }
    }

    private ListNode traverse(ListNode head) {
        if (head == null) {
            return null;
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

    private void print(ListNode root) {
        if (root == null) {
            return;
        } else {
            System.out.print(root.val + " ");
            print(root.next);
        }
    }

    public static void main(String[] args) {
        ListNode pHead = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode tmp = new ListNode(3);
        three.next = tmp;
        ListNode four = new ListNode(2);
        ListNode five = new ListNode(1);
        pHead.next = two;
        two.next = three;
        //three.next = four;
        tmp.next = four;
        four.next = five;
        // ListNode six = new ListNode(6);
        // five.next = six;
        System.out.println(new Palindrome().isPalindrome(pHead));
    }
}