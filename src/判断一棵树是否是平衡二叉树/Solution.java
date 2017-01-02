package 判断一棵树是否是平衡二叉树;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}

public class Solution {
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean[] res = new boolean[1];
        res[0] = true;
        depth(root, 1, res);
        return res[0];
    }

    private int depth(TreeNode root, int acc, boolean res[]) {
        int leftHeight, rightHeight;
        if (root.left != null) {
            leftHeight = depth(root.left, acc + 1, res);
        } else {
            leftHeight = acc;
        }
        if (root.right != null) {
            rightHeight = depth(root.right, acc + 1, res);
        } else {
            rightHeight = acc;
        }
        if (Math.abs(leftHeight - rightHeight) > 1) {
            res[0] = false;
        }
        return Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left1 = new TreeNode(1);
        TreeNode left2 = new TreeNode(1);
        root.left = left1;
        left1.left = left2;
        System.out.println(new Solution().IsBalanced_Solution(root));
    }
}