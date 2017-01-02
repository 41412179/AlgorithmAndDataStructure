package 复杂链表的复制;

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

public class Solution {
    public RandomListNode Clone(RandomListNode pHead) {
        if (null == pHead)
            return null;
        cloneNext(pHead);
        cloneRandom(pHead);
        RandomListNode newHead = new RandomListNode(-1);

        removeThenLink(newHead, pHead);
        // printList(pHead.next);
        // printRand(pHead.next);
        // RandomListNode newHead = pHead.next;

        // printList(newHead.next);
        // printRand(newHead.next);
        // printList(pHead);
        return newHead.next;
    }

    private void printRand(RandomListNode head) {
        if (null == head) {
            System.out.println();
            return;
        }
        if (null == head.random) {
            System.out.print("null-> ");
        } else {
            System.out.print(head.random.label + "-> ");
        }
        printRand(head.next);
    }

    private void printList(RandomListNode head) {
        if (null == head) {
            System.out.println();
            return;
        }
        System.out.print(head.label + "-> ");
        printList(head.next);
    }

    private void removeThenLink(RandomListNode newHead, RandomListNode pHead) {
        if (pHead == null) {
            return;
        } else {
            newHead.next = pHead.next;
            if (pHead.next != null) {
                pHead.next = pHead.next.next;
            }
            removeThenLink(newHead.next, pHead.next);
        }
    }

    private void cloneRandom(RandomListNode pHead) {
        if (null == pHead) {
            return;
        }
        if (null == pHead.random) {
            pHead.next.random = null;
        } else {
            pHead.next.random = pHead.random.next;
        }
        cloneRandom(pHead.next.next);
    }

    private void cloneNext(RandomListNode pHead) {
        if (null == pHead) {
            return;
        }
        RandomListNode newNode = new RandomListNode(pHead.label);
        newNode.next = pHead.next;
        pHead.next = newNode;
        cloneNext(newNode.next);
    }

    public static void main(String[] args) {
        RandomListNode pHead1 = new RandomListNode(1);
        RandomListNode pHead2 = new RandomListNode(2);
        RandomListNode pHead3 = new RandomListNode(3);
        RandomListNode pHead4 = new RandomListNode(4);
        RandomListNode pHead5 = new RandomListNode(5);

        pHead1.next = pHead2;
        pHead2.next = pHead3;
        pHead3.next = pHead4;
        pHead4.next = pHead5;

        pHead1.random = pHead3;
        pHead2.random = pHead4;
        pHead3.random = null;
        pHead4.random = pHead5;
        pHead5.random = pHead4;
        new Solution().Clone(pHead1);
    }
}