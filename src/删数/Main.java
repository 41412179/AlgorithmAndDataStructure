package 删数;

import java.util.Scanner;

/**
 * Created by h on 16-12-28.
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int f = 0;
        while (in.hasNext()) {
            f=0;
            int n = in.nextInt();
            if (n > 1000) n = 1000;
            for (int i = 2; i <= n; i++) {
                f = (f + 3) % i;
            }
            System.out.println(f);
        }
        in.close();
    }
}
