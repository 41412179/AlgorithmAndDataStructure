package 回文串;

import java.util.Scanner;

/**
 * Created by h on 16-12-28.
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.next();
            int len = s.length();
            StringBuilder sb = new StringBuilder();
            for (int i = len - 1; i >= 0; i--) {
                sb.append(s.charAt(i));
            }
            if (process(s) || process(sb.toString())) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }
        in.close();
    }

    private static boolean process(String s) {
        int len = s.length();
        int flag = 1;
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                if (flag == 1) {
                    flag--;
                    len += 1;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
