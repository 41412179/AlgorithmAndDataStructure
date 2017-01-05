package 小东分苹果;

import java.util.Scanner;

/**
 * Created by h on 16-12-28.
 */
public class Main {
    public int getInitial(int n) {
        //return n*n-n+1;
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            int count = i;
            boolean flag = false;
            for (int j = 1; j <= n; j++) {
                count--;
                if (count % n == 0) {
                    count = count / n * (n - 1);
                } else {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(new Main().getInitial(2));
        while (in.hasNext()) {

        }
        in.close();
    }
}
