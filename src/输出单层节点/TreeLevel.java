package 输出单层节点;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class TreeLevel {

    public ListNode p;

    public ListNode getTreeLevel(TreeNode root, int dep) {
        ListNode head = new ListNode(-1);
        p = head;
        preOrder(root, dep);
        return head.next;
    }

    private void preOrder(TreeNode root, int dep) {
        if (root == null || dep == 0) {
            return;
        }
        if (dep == 1) {
            p.next = new ListNode(root.val);
            p = p.next;
        }
        preOrder(root.left, dep - 1);
        preOrder(root.right, dep - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(3);
        TreeNode left2 = new TreeNode(4);
        root.left = left1;
        root.right = right1;
        left1.left = left2;
        TreeNode right2 = new TreeNode(5);
        left1.right = right2;
        print(new TreeLevel().getTreeLevel(root, 1));
    }

    private static void print(ListNode root) {
        if (root == null) {
            return;
        } else {
            System.out.print(root.val + " ");
            print(root.next);
        }
    }

}
