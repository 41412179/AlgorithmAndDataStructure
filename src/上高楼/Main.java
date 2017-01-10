package 上高楼;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * Created by h on 16-12-28.
 */
public class Main {
    public int countWays(int n) {
        int mod = 1000000007;
        int a = 1;
        int b = 2;
        int c = -1;
        for (int i = 3; i <= n; i++) {
            c = a + b;
            c %= mod;
            if (i == n) break;
            a = b;
            b = c;
        }
        return c;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        while (in.hasNext()) {

        }
        in.close();
    }
}
