package 孩子们的游戏;

import java.util.Scanner;

/**
 * Created by h on 16-12-28.
 */
public class Main {
    public int LastRemaining_Solution(int n, int m) {
        if(n == 0 || m == 0){
            return -1;
        }
        int f = 0;
        for (int i = 1; i <= n; i++) {
            f = (f + m) % i;
        }
        return f;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {

        }
        in.close();
    }
}
