package 最大差值;

/**
 * Created by h on 16-12-22.
 */
public class Solution {
    public int getDis(int[] A, int n) {
        int[] max = new int[n];
        int[] min = new int[n];
        min[0] = A[0];
        for (int i = 1; i < n; i++) {
            if (A[i] < min[i - 1]) {
                min[i] = A[i];
            } else {
                min[i] = min[i - 1];
            }
        }
        max[n - 1] = A[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (A[i] > max[i + 1]) {
                max[i] = A[i];
            } else {
                max[i] = max[i + 1];
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (max[i] - min[i] > res) {
                res = max[i] - min[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A={5477,12458,4200,10290,7790,11432,10743};
        int n = A.length;
        System.out.println(new Solution().getDis(A, n));
    }
}
