package 寻找下一个节点;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {

    public int findSucc(TreeNode root, int p) {
        boolean[] sign = new boolean[1];
        sign[0] = false;
        int[] res = new int[1];
        findSuccHelp(root, sign, p, res);
        return res[0];
    }

    private void findSuccHelp(TreeNode root, boolean[] sign, int p, int[] res) {

        if (root.left != null)
            findSuccHelp(root.left, sign, p, res);

        if (sign[0]) {
            res[0] = root.val;
            sign[0] = false;
            return;
        }

        if (root.val == p) {
            sign[0] = true;
        }
        if (root.right != null)
            findSuccHelp(root.right, sign, p, res);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(3);
        root.left = left1;
        root.right = right1;
        System.out.println(new Solution().findSucc(root, 1));
    }

}
