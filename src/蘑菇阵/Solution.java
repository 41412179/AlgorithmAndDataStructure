package 蘑菇阵;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by h on 16-12-28.
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n, m, k;
        double[][] map = new double[20][20];
        double[][] dp = new double[20][20];
        while (in.hasNext()) {
            n = in.nextInt();
            m = in.nextInt();
            k = in.nextInt();
            init(map, dp);
            for (int i = 0; i < k; i++) {
                int x = in.nextInt();
                int y = in.nextInt();
                map[x - 1][y - 1] = 1;
            }
            if (map[0][0] != 1)
                dp[0][0] = 1;
            else {
                System.out.println("0.00");
                continue;
            }
            //设立边界
            for (int i = 1; i < m; i++) {
                if (map[0][i] != 1) {
                    dp[0][i] = 0.5 * dp[0][i - 1];
                } else {
                    break;
                }
            }
            for (int i = 1; i < n; i++) {
                if (map[i][0] != 1) {
                    dp[i][0] = 0.5 * dp[i - 1][0];
                } else break;
            }

            for (int i = 1; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    if (map[i][j] != 1)
                        if (i == n - 1) {
                            dp[i][j] = 0.5 * dp[i - 1][j] + dp[i][j - 1];
                        } else {
                            if (j == m - 1) {
                                dp[i][j] = 0.5 * dp[i][j - 1] + dp[i - 1][j];
                            } else {
                                dp[i][j] = 0.5 * (dp[i - 1][j] + dp[i][j - 1]);
                            }
                        }
                    else dp[i][j] = 0;
                }
            }
            DecimalFormat df = new DecimalFormat("######0.00");
             System.out.println(df.format(dp[n - 1][m - 1]));
            //System.out.printf("%.2f", dp[n - 1][m - 1]);
        }
        in.close();
    }

    private static void init(double[][] map, double[][] dp) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                map[0][0] = 0;
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = 0;
            }
        }
    }
}
