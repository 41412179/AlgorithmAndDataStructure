package 数字颠倒;

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
            for (int i = len - 1; i >= 0; i--) {
                System.out.print(s.charAt(i));
            }
            System.out.println();
        }
        in.close();
    }
}
