package 维护X的秩;

/**
 * Created by h on 16-12-21.
 */
class Node {
    int count = 0;
    Node left = null;
    Node right = null;
    int key = 0;

    Node(int key, int count) {
        this.key = key;
        this.count = count;
    }
}

public class Solution {
    public int[] getRankOfNumber(int[] A, int n) {
        int[] res = new int[n];
        Node root = new Node(-1, 0);
        int[] ans = new int[1];
        for (int i = 0; i < n; i++) {
            ans[0] = 0;
            root = insert(A[i], root, ans);
            res[i] = ans[0];
        }
        return res;
    }

    private Node insert(int x, Node root, int[] ans) {
        if (root.key == -1) {
            root = new Node(x, 0);
            return root;
        }
        if (x > root.key) {
            if (root.right == null) {
                ans[0] += root.count + 1;
                root.right = new Node(x, ans[0]);
            } else {
                insert(x, root.right, ans);
            }
        } else {
            if (root.left == null) {
                root.left = new Node(x, ans[0]);
            } else {
                insert(x, root.left, ans);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 0, 3};
        int n = A.length;
        int[] res = new Solution().getRankOfNumber(A, n);
        for (int i = 0; i < n; i++) {
            System.out.println(res[i]);
        }
    }
}
