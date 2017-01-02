package 重建二叉树;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null) {
            return null;
        }
        int len = pre.length;
        if (len == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);

        for (int i = 0; i < len; i++) {
            if (in[i] == pre[0]) {
                int[] beginIn = new int[i];

                for (int j = 0; j < i; j++) {
                    beginIn[j] = in[j];
                }
                int[] beginPre = new int[i];
                for (int j = 1; j < i + 1; j++) {
                    beginPre[j - 1] = pre[j];
                }

                int[] endIn = new int[len - i - 1];
                int[] endPre = new int[len - i - 1];
                for (int j = i + 1; j < len; j++) {
                    endIn[j - i - 1] = in[j];
                    endPre[j - i - 1] = pre[j];
                }

                root.left = reConstructBinaryTree(beginPre, beginIn);
                root.right = reConstructBinaryTree(endPre, endIn);
                break;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        int[] pre = {1, 3, 5, 7, 2, 11, 29};
        int[] in = {5, 3, 7, 1, 11, 2, 29};
        print(new Solution().reConstructBinaryTree(pre, in));
    }

    private static void print(TreeNode root) {
        if (root == null) {
            return;
        } else {
            System.out.print(root.val + " ");
            print(root.left);
            print(root.right);
        }
    }
}