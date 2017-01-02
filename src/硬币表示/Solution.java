package 硬币表示;

public class Solution {

    // 25, 10, 5, 1
    public int countWays(int n) {
        final int mod = 1000000007;
        int[][] dp = new int[4][n + 1];
        for (int i = 0; i < 4; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i * 25 <= n; i++) {
            dp[0][i * 25] = 1;
        }
        int[] arr = {25, 10, 5, 1};
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j];
                dp[i][j] %= mod;
                dp[i][j] += j - arr[i] >= 0 ? dp[i][j - arr[i]] : 0;
                dp[i][j] %= mod;
            }
        }
        return dp[3][n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countWays(6));
    }

}
