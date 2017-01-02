package 将搜索二叉树转化为双向链表;

import java.util.ArrayDeque;

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
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        ArrayDeque<TreeNode> ad = new ArrayDeque<TreeNode>();
        inOrder(pRootOfTree, ad);
        TreeNode head = ad.pop();
        head.left = null;
        TreeNode before = head;
        while (!ad.isEmpty()) {
            TreeNode tmp = ad.pop();
            tmp.left = before;
            before.right = tmp;
            before = tmp;
        }
        before.right = null;
        return head;
    }

    private void inOrder(TreeNode pRootOfTree, ArrayDeque<TreeNode> ad) {
        if (pRootOfTree == null) {
            return;
        }
        inOrder(pRootOfTree.left, ad);
        ad.add(pRootOfTree);
        inOrder(pRootOfTree.right, ad);
    }

    public static void main(String[] args) {

    }

}
