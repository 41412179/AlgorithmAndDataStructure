package 上台阶;

import java.util.Scanner;

/**
 * Created by h on 16-12-28.
 */
public class Main {

    public int countWays(int n) {
        int mod = 1000000007;
        int[] f = new int[Integer.MAX_VALUE];
        f[0] = 1;
        f[1] = 1;
        f[2] = 2;
        for (int i = 3; i <= n; i++) {
            f[i] = (f[i - 1] + f[i - 2]) % mod;
        }
        return f[n];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {

        }
        in.close();
    }
}
