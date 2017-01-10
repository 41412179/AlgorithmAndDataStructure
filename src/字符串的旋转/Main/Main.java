package 字符串的旋转.Main;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * Created by h on 16-12-28.
 */
public class Main {
    public String rotateString(String A, int n, int p) {
        return A.substring(p + 1, n) + A.substring(0, p + 1);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        while (in.hasNext()) {

        }
        in.close();
    }
}
