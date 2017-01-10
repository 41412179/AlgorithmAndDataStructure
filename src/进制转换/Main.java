package 进制转换;

import java.io.BufferedInputStream;
import java.io.InterruptedIOException;
import java.util.Scanner;

/**
 * Created by h on 16-12-28.
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            System.out.println(Integer.toString(n, m).toUpperCase());
        }
        in.close();
    }
}
