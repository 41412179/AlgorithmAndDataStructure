package 数字和为sum的方法;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * Created by h on 16-12-28.
 */
public class Main {


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int[][] dp = new int[1001][1001];
        int[] seq = new int[1001];
        while (in.hasNext()) {
            int n = in.nextInt();
            int sum = in.nextInt();
            for (int i = 0; i < n; i++) {
                seq[i] = in.nextInt();
            }
            if (seq[0] == 0)
                dp[0][0] = 1;
            else dp[0][0] = 0;
            for (int i = 1; i < n; i++) {
                if (seq[i] == 0) {
                    dp[i][0] = dp[i - 1][0] + 1;
                } else {
                    dp[i][0] = dp[i - 1][0];
                }
            }
            for (int i = 1; i <= sum; i++) {
                if (seq[0] >= i) {
                    //dp[0][i]
                }
            }
        }
        in.close();
    }
}
