package 明明的随机数;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by h on 16-12-28.
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int[] num = null;
        while (in.hasNext()) {
            int t = in.nextInt();
            num = new int[t];
            for (int i = 0; i < t; i++) {
                num[i] = in.nextInt();
            }
            Arrays.sort(num);
            if (t > 0)
                System.out.println(num[0]);
            for (int i = 1; i < t; i++) {
                if (num[i] != num[i - 1]) System.out.println(num[i]);
            }
        }
        in.close();
    }
}
