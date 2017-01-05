package 兔子藏洞;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * Created by h on 16-12-28.
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        boolean[] visited = new boolean[21];
        while (in.hasNext()) {
            for (int i = 1; i < 21; i++) {
                visited[i] = false;
            }
            int x = in.nextInt();
            int n = in.nextInt();
            int step = 1;
            for (int i = 1; i <= n; i++) {
                x += step + i;
                if (!visited[x % 20]) {
                    if (x % 20 == 0) {
                        visited[20] = true;
                        x = x % 20;
                    } else {
                        visited[x % 20] = true;
                        x = x % 20;
                    }
                }
            }
            boolean flag = true;
            for (int i = 1; i < 21; i++) {
                if (!visited[i]) {
                    flag = false;
                    System.out.print((i) + " ");
                }
            }
            if (flag) System.out.println(-1);
            System.out.println();
        }
        in.close();
    }
}
