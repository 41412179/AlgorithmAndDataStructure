package 求二叉树的深度;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }

}

public class Solution {
    public int TreeDepth(TreeNode root) {
        int res = 0;
        if (root == null) {
            return res;
        } else {
            if (root.left != null) {
                int a = 1 + TreeDepth(root.left);
                if (root.right != null) {
                    int b = 1 + TreeDepth(root.right);
                    return Math.max(a, b);
                } else {
                    return a;
                }
            } else {
                if (root.right != null) {
                    int a = 1 + TreeDepth(root.right);
                    return a;
                } else {
                    return 1;
                }
            }
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        root.left = t1;
        root.right = t2;

        TreeNode t3 = new TreeNode(1);
//		TreeNode t4 = new TreeNode(2);
        t1.left = t3;
//		t3.right = t4;

        // TreeNode root=null;

        System.out.println(new Solution().TreeDepth(root));
    }
}
