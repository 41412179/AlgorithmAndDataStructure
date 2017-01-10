package 阶乘尾0;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * Created by h on 16-12-28.
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        while (in.hasNext()) {
            int n = in.nextInt();
            int res = 0;
            for (int i = 5; i <= n; i++) {
                int j = i;
                while (true) {
                    if (j % 5 == 0) {
                        j /= 5;
                        res++;
                    } else {
                        break;
                    }
                }
            }
            System.out.println(res);
        }
        in.close();
    }
}
