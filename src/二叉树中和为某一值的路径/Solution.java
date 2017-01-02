package 二叉树中和为某一值的路径;

import java.util.ArrayList;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {
    ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<Integer> path = new ArrayList<Integer>();
        if (null == root) {
            return paths;
        }
        findPathHelper(root, target, 0, paths, path);
        return paths;
    }

    private void findPathHelper(TreeNode root, int target, int acc, ArrayList<ArrayList<Integer>> paths,
                                ArrayList<Integer> path) {
        path.add(root.val);
        acc += root.val;
        if (root.left != null || root.right != null) {
            if (root.left != null) {
                ArrayList<Integer> leftPath = new ArrayList<Integer>();
                int size = path.size();
                for (int i = 0; i < size; i++) {
                    leftPath.add(path.get(i));
                }
                findPathHelper(root.left, target, acc, paths, leftPath);
            }
            if (root.right != null) {
                ArrayList<Integer> rightPath = new ArrayList<Integer>();
                int size = path.size();
                for (int i = 0; i < size; i++) {
                    rightPath.add(path.get(i));
                }
                findPathHelper(root.right, target, acc, paths, rightPath);
            }
        } else {
            if (acc == target) {
                paths.add(path);
            } else {
                return;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        root.left = left1;
        TreeNode left2 = new TreeNode(3);
        left1.left = left2;

        TreeNode right1 = new TreeNode(4);
        root.right = right1;
        TreeNode right2 = new TreeNode(5);
        right1.right = right2;
        Solution s = new Solution();
        s.FindPath(root, 10);

        for (int i = 0; i < s.paths.size(); i++) {
            for (int j = 0; j < s.paths.get(i).size(); j++) {
                System.out.print(s.paths.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}