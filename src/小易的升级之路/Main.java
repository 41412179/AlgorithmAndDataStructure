package 小易的升级之路;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * Created by h on 16-12-28.
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        while (in.hasNext()) {
            int n = in.nextInt();
            int a = in.nextInt();
            for (int i = 0; i < n; i++) {
                int val = in.nextInt();
                if (val <= a) a += val;
                else a += gcd(a, val);
            }
            System.out.println(a);
        }
        in.close();
    }

    private static int gcd(int a, int b) { //a < b
        while (true) {
            int tmp = b;
            if (a % b == 0) return b;
            b = a % b;
            a = tmp;
        }
    }
}
