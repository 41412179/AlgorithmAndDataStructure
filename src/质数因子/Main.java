package 质数因子;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * Created by h on 16-12-28.
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        while (in.hasNext()) {
            long num = in.nextLong();
            while (num != 1) {
                for (int i = 2; i <= num; i++) {
                    if (num % i == 0) {
                        System.out.print(i + " ");
                        num /= i;
                        break;
                    }
                }
            }
            System.out.println();
        }
        in.close();
    }
}
