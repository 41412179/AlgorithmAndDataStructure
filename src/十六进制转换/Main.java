package 十六进制转换;

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
            String s = in.nextLine();
            s = s.substring(2);
            System.out.println(Integer.parseInt(s, 16));
        }
        in.close();
    }
}
