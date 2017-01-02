package 之字形打印二叉树;

import java.util.ArrayDeque;
import java.util.ArrayList;

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
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (pRoot == null) {
            return res;
        }
        ArrayDeque<TreeNode> a = new ArrayDeque<>();
        ArrayDeque<TreeNode> b = new ArrayDeque<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        tmp.add(pRoot.val);
        res.add(tmp);
        a.addLast(pRoot);

        while (!a.isEmpty() || !b.isEmpty())
        {
            tmp = new ArrayList<>();
            while (!a.isEmpty()) {
                TreeNode tn = a.removeLast();
                if (tn.right != null) {
                    tmp.add(tn.right.val);
                    b.addLast(tn.right);
                }
                if (tn.left != null) {
                    tmp.add(tn.left.val);
                    b.addLast(tn.left);
                }
            }
            if(tmp.size()>0)
            res.add(tmp);
            tmp = new ArrayList<Integer>();
            while (!b.isEmpty()) {
               TreeNode tn = b.removeLast();
                if (tn.left != null) {
                    tmp.add(tn.left.val);
                    a.addLast(tn.left);
                }
                if(tn.right != null){
                    tmp.add(tn.right.val);
                    a.addLast(tn.right);
                }
            }
            if(tmp.size()>0)
            res.add(tmp);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
