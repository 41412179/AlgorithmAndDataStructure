package 计算字符个数;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * Created by h on 16-12-28.
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        while (in.hasNext()) {
            String s = in.nextLine();
            s = s.toLowerCase();
            int len = s.length();
            char ch = in.next().toLowerCase().charAt(0);
            int res = 0;
            for (int i = 0; i < len; i++) {
                if (s.charAt(i) == ch) res++;
            }
            System.out.println(res);
        }
        in.close();
    }
}
