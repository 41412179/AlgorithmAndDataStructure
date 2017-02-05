package 提取不重复的整数;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * Created by h on 16-12-28.
 */
public class Main {


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        while (in.hasNext()) {
            int[] num = new int[10];
            boolean[] use = new boolean[10];
            String s = in.next();
            int t = 0;
            int len = s.length();
            for (int i = len - 1; i >= 0; i--) {
                int val = s.charAt(i) - '0';
                if (!use[val]) {
                    use[val] = true;
                    num[t++] = val;
                }
            }
            for (int i = 0; i < t; i++) {
                System.out.print(num[i]);
            }
            System.out.println();
        }
        in.close();
    }
}
