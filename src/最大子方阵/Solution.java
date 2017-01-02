package 最大子方阵;

/**
 * Created by h on 16-12-18.
 */
public class Solution {

    public int maxSubMatrix(int[][] mat, int n) {
        int[][] right = new int[n][n];
        int[][] down = new int[n][n];
        //时间复杂度O（n3）
        int type = 1;
        preProcess(mat, right, down, n, type);
        int[] ans = new int[1];
        ans[0] = 0;
        dp(ans, right, down, n);
        type = 0;
        preProcess(mat, right, down, n, type);
        dp(ans, right, down, n);
        return ans[0];

    }

    private void dp(int[] ans, int[][] right, int[][] down, int n) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int maxNum = Math.min(right[i][j], down[i][j]);
                for (int k = maxNum; k > 0; k--) {
                    if (down[i][j + k - 1] >= k && right[i + k - 1][j] >= k) {
                        ans[0] = Math.max(k, ans[0]);
                        break;
                    }
                }
            }
        }
    }

    private void preProcess(int[][] mat, int[][] right, int[][] down, int n, int type) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                right[i][j] = 0;
                down[i][j] = 0;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = j; k < n; k++) {
                    if (mat[i][k] == type) {
                        right[i][j]++;
                    } else {
                        break;
                    }
                }
                for (int k = i; k < n; k++) {
                    if (mat[k][j] == type) {
                        down[i][j]++;
                    } else {
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] mat = {
                {0, 1, 1, 1, 1},
                {0, 1, 0, 0, 1},
                {0, 1, 0, 0, 1},
                {0, 1, 1, 1, 1},
                {0, 1, 0, 1, 1}
        };
        int n = mat.length;
        System.out.println(new Solution().maxSubMatrix(mat, n));
    }
}
