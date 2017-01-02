package C;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by h on 16-12-24.
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t;
        t = input.nextInt();
        int[] dp = new int[100000 + 1];
        for (int i = 0; i < t; i++) {
            int n = input.nextInt();
            for (int j = 0; j < n; j++) {
                dp[j] = input.nextInt();
            }
            Arrays.sort(dp, 0, n);
            int sum = 0;
            int before = dp[0];
            for (int k = 1; k < n; k++) {
                if (dp[k] == before) {
                    sum++;
                    continue;
                } else {
                    before = dp[k];
                }
            }
            if (sum == 0) {
                System.out.println("none");
            } else {
                before = dp[0];

                boolean flag = false;
                int num = 0;
                for (int k = 1; k < n; k++) {
                    if (dp[k] == before) {
                        if (num == 0) {
                            if (flag == false) {
                                System.out.print(before);
                                flag = true;
                            } else {
                                System.out.print(" " + before);
                            }
                            num++;
                        }
                    } else {
                        before = dp[k];
                        num = 0;
                    }
                }
                System.out.println();
            }
        }
        input.close();
    }
}
