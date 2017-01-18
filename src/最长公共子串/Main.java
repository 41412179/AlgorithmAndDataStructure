package 最长公共子串;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * Created by h on 16-12-28.
 */
public class Main {
    public int findLongest(String A, int n, String B, int m) {
        int[][] dp = new int[n][m];
        if (A.charAt(0) == B.charAt(0)) dp[0][0] = 1;
        for (int i = 1; i < n; i++) {
            if (A.charAt(i) == B.charAt(0)) dp[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            if (A.charAt(0) == B.charAt(i)) dp[0][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (A.charAt(i) == B.charAt(j)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
            }
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        while (in.hasNext()) {

        }
        in.close();
    }
}
