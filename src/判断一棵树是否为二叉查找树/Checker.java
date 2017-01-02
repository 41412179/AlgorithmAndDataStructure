package 判断一棵树是否为二叉查找树;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Checker {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode right1 = new TreeNode(2);
        TreeNode right2 = new TreeNode(3);
        right1.right = right2;
        root.right = right1;
        TreeNode left1 = new TreeNode(2);
        root.left = left1;
        System.out.println(new Checker().checkBST(root));
    }

    public boolean checkBST(TreeNode root) {
        // write code here
        if (root == null) {
            return true;
        }
        int init = Integer.MIN_VALUE;
        return checkBSTHelp(root, init);
    }

    private boolean checkBSTHelp(TreeNode root, int init) {
        if (root == null) {
            return true;
        }
        if (root.left != null) {
            return checkBSTHelp(root.left, init) && checkBSTHelp(root.right, root.val);
        } else {
            if (root.right != null) {
                return checkBSTHelp(root.right, root.val);
            } else {
                if (init < root.val) {
                    return true;
                } else {
                    return false;
                }
                //return true;
            }
        }
    }
}
