package 字符串分隔;

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
            int start = 0;
            int len = s.length();
            while (true) {
                start += 8;
                if (start > len) {
                    int num = 8 - (len - (start - 8));

                    System.out.print(s.substring(start - 8, len));
                    for (int i = 0; i < num; i++) {
                        System.out.print(0);
                    }
                    System.out.println();
                    break;
                } else {
                    if (start < len) {
                        System.out.println(s.substring(start - 8, start));
                        continue;
                    } else {
                        System.out.println(s.substring(start - 8, start));
                        break;
                    }

                }
            }
        }
        in.close();
    }
}
