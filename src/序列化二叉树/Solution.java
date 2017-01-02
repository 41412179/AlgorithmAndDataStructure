package 序列化二叉树;

import java.util.ArrayDeque;

/**
 * Created by h on 16-12-26.
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
    //按先序遍历
    String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        return sb.toString();
    }

    private void preOrder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#!");
            return;
        }
        sb.append(root.val + "!");
        preOrder(root.left, sb);
        preOrder(root.right, sb);
    }

    TreeNode Deserialize(String str) {
        //为了方便编写，牺牲空间作为代价
        String[] values = str.split("!");
        ArrayDeque<String> ad = new ArrayDeque<String>();
        for (int i = 0; i < values.length; i++) {
            ad.addLast(values[i]);
        }
        return reConOrder(ad);
    }

    private TreeNode reConOrder(ArrayDeque<String> ad) {
        String s = ad.pollFirst();
        if (s.equals("#")) {
            return null;
        }
        TreeNode head = new TreeNode(Integer.valueOf(s));
        head.left = reConOrder(ad);
        head.right = reConOrder(ad);
        return head;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(12);
        TreeNode left1 = new TreeNode(3);
        root.left = left1;
        System.out.println(new Solution().Serialize(root));
    }
}
