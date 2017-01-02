package 把二叉树打印成多行;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class Solution {
    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (null == pRoot) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(pRoot);
        int size = 1;
        int lo = 0;
        int newSize = 0;
        int index = 0;
        res.add(new ArrayList<Integer>());
        while (!q.isEmpty()) {
            // ArrayList<Integer> als = new ArrayList<Integer>();
            while (lo < size) {

                TreeNode tn = q.poll();
                res.get(index).add(tn.val);
                if (tn.left != null) {
                    q.add(tn.left);
                    newSize++;
                }
                if (tn.right != null) {
                    q.add(tn.right);
                    newSize++;
                }
                lo++;
            }
            if (!q.isEmpty()) {
                index++;
                res.add(new ArrayList<Integer>());
            }
            size = newSize;
            newSize = 0;
            lo = 0;
        }
        return res;
    }
}
