package 发奖金;

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
            int[] seq = new int[n];
            for (int i = 0; i < n; i++) {
                seq[i] = in.nextInt();
            }
            int[] leftToRight = new int[n];
            int[] rightToLeft = new int[n];
            leftToRight[0] = 1;
            rightToLeft[n - 1] = 1;
            for (int i = 1; i < n; i++) {
                if (seq[i] > seq[i - 1]) {
                    leftToRight[i] = leftToRight[i - 1] + 1;
                } else {
                    leftToRight[i] = 1;
                }
            }
            for (int i = n - 2; i >= 0; i--) {
                if (seq[i] > seq[i + 1]) {
                    rightToLeft[i] = rightToLeft[i + 1] + 1;
                } else
                    rightToLeft[i] = 1;
            }
            int res = 0;
            for (int i = 0; i < n; i++) {
                res += Math.max(rightToLeft[i], leftToRight[i]);
            }
            System.out.println(res);
        }
        in.close();
    }
}
