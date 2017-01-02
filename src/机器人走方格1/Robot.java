package 机器人走方格1;

public class Robot {

    public int countWays(int x, int y) {
        int[][] dp = new int[12][12];
        int maxn = 12;
        for (int i = 1; i < maxn; i++) {
            dp[1][i] = 1;
            dp[i][1] = 1;
        }
        for (int i = 2; i < maxn; i++) {
            for (int j = 2; j < maxn; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[x][y];
    }

    public static void main(String[] args) {
        System.out.println(new Robot().countWays(2, 2));
    }

}
