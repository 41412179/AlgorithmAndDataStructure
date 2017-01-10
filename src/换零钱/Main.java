package 换零钱;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * Created by h on 16-12-28.
 */
public class Main {
    public int countWays(int[] changes, int n, int x) {
        int[][] dp = new int[n][x + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i <= x; i++) {
            if (i % changes[0] == 0) {
                dp[0][i] = 1;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= x; j++) {

                if (j - changes[i] >= 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - changes[i]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][x];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int[] changes = {5, 10, 25, 1};
        int n = changes.length;
        int x = 15;
        System.out.println(new Main().countWays(changes, n, x));
        in.close();
    }
}
