package 连续最大和;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * Created by h on 16-12-28.
 */


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int[] seq = new int[100001];
        int[] res = new int[100001];
        while (in.hasNext()) {
            int n = in.nextInt();
            for (int i = 0; i < n; i++) {
                seq[i] = in.nextInt();
            }
            res[0] = seq[0];
            for (int i = 1; i < n; i++) {
                if (res[i - 1] <= 0) {
                    res[i] = seq[i];
                } else {
                    res[i] = seq[i] + res[i - 1];
                }
            }
            int ans = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                if (ans < res[i]) {
                    ans = res[i];
                }
            }
            System.out.println(ans);
        }
        in.close();
    }
}
