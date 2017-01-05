package 拓扑结构相同子树;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * Created by h on 16-12-28.
 */

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Main {
    private boolean same(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return true;
        }
        if (A != null && B != null) {
            if (A.val == B.val) {
                return same(A.left, B.left) && same(A.right, B.right);
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean chkIdentical(TreeNode A, TreeNode B) {
        if (A == null) {
            return false;
        }
        boolean left = false, right = false, res;
        if (A.left != null) left = chkIdentical(A.left, B);
        res = same(A, B);
        if (A.right != null) right = chkIdentical(A.right, B);
        return left || res || right;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        System.out.println(new Main().chkIdentical(root, right));
        in.close();
    }
}
