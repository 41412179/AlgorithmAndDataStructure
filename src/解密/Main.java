package 解密;

import java.util.Arrays;
import java.util.Scanner;


/**
 * Created by h on 16-12-28.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.next();
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            s = new String(chars);
            printf("", s);
        }
        in.close();
    }

    private static void printf(String res, String s) {
        if (s.equals("")) {
            System.out.println(res);
        }
        int len = s.length();
        for (int i = 0; i < len; i++) {
            printf(res + s.substring(i, i + 1), s.substring(0, i) + s.substring(i + 1, len));
        }
    }
}
