package 下一个较大元素;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by h on 16-12-19.
 */
public class Solution {
    public int[] findNext(int[] A, int n) {
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; --i) {
            res[i] = -1;
            for (int j = i + 1; j < n; j++) {
                if (A[j] > A[i]) {
                    if (res[i] == -1) {
                        res[i] = A[j];
                    } else {
                        res[i] = Math.min(res[i], A[j]);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {1, 3, 4, 2};
        int n = A.length;
        for (int i : new Solution().findNext(A, n)) {
            System.out.print(i + " ");
        }
    }

}
