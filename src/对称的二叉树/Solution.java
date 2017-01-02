package 对称的二叉树;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }

}

public class Solution {

    boolean isSymmetrical(TreeNode pRoot) {

        if (isSymmetricalHelper(pRoot, pRoot)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isSymmetricalHelper(TreeNode pRoot, TreeNode pRoot2) {
        if (pRoot != null) {
            if (pRoot2 != null) {
                if (pRoot.val == pRoot2.val) {
                    return isSymmetricalHelper(pRoot.left, pRoot2.right)
                            && isSymmetricalHelper(pRoot.right, pRoot2.left);
                }
            }
        } else {
            if (pRoot2 == null) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }

}
