package 钓鱼比赛;

import java.io.BufferedInputStream;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by h on 16-12-28.
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n, m, t, x, y;
        while (in.hasNext()) {

            n = in.nextInt();
            m = in.nextInt();
            t = in.nextInt();
            x = in.nextInt() - 1;
            y = in.nextInt() - 1;
            double cc = 0;
            double ss = 1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (x == i && y == j) {
                        cc = in.nextDouble();
                        ss += cc;
                    } else {
                        ss += in.nextDouble();
                    }
                }
            }
            cc = 1 - cc;
            ss = 1 - 1.0 * ss / (n * m);
            for (int i = 1; i < t; i++) {
                cc *= cc;
                ss *= ss;
            }
            cc = 1 - cc;
            ss = 1 - ss;
            if (cc - ss < 10e-6) {
                System.out.println("equal");
                System.out.println(new DecimalFormat("0.00").format(cc));
            } else {
                if (cc - ss > 10e-6) {
                    System.out.println("cc");
                    System.out.println(new DecimalFormat("0.00").format(cc));
                } else {
                    System.out.println("ss\n" + ss);
                    System.out.println(new DecimalFormat("0.00").format(ss));
                }
            }
        }
        in.close();
    }
}
