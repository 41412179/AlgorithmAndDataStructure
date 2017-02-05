package 取近似值;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * Created by h on 16-12-28.
 */
public class Main {


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        while (in.hasNext()) {
            String s = in.next();
            int len = s.length();
            for (int i = 0; i < len; i++) {
                if (s.charAt(i) == '.') {
                    if (s.charAt(i + 1) >= '5') {
                        System.out.println(Integer.parseInt(s.substring(0, i)) + 1);
                    } else {
                        System.out.println(Integer.parseInt(s.substring(0, i)));
                    }
                }
            }
        }
        in.close();
    }
}
