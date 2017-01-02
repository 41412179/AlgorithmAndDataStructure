package 二叉搜索树的第K个节点;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * Created by h on 16-12-25.
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class Solution {

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null) {
            return null;
        }
        Stack<TreeNode> s = new Stack<>();
        inOrder(pRoot, s);
        while (--k != 0) {
            if (!s.isEmpty()) {
                s.pop();
            } else {
                return null;
            }
        }
        if (s.isEmpty()) return null;
        else return s.peek();
    }

    private void inOrder(TreeNode pRoot, Stack<TreeNode> ad) {
        if (pRoot == null) {
            return;
        }
        inOrder(pRoot.right, ad);
        ad.push(pRoot);
        inOrder(pRoot.left, ad);

    }

    public static void main(String[] args) {
        //new Solution().KthNode()
    }
}
