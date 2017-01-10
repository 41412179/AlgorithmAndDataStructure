package 顺时针打印矩阵;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * Created by h on 16-12-28.
 */
public class Main {
    public int[] clockwisePrint(int[][] mat, int n, int m) {
        int[] res = new int[n * m];
        int t = 0;
        int nn = 0, mm = 0;
        if (n % 2 == 1)
            nn = n + 1;
        else nn = n;
        if (m % 2 == 1)
            mm = m + 1;
        else mm = m;
        for (int x = 0, y = 0; x < nn / 2 && y < mm / 2; x++, y++) {
            for (int i = y; i <= (m - 1) - y; i++) {
                res[t++] = mat[x][i];
            }
            for (int i = x + 1; i < (n - 1) - x; i++) {
                res[t++] = mat[i][(m - 1) - y];
            }
            for (int i = (m - 1) - y; i >= y; i--) {
                if (x != (n - 1) - x)
                    res[t++] = mat[(n - 1) - x][i];
            }
            for (int i = (n - 2) - x; i > x; i--) {
                if (y != (m - 1) - y)
                    res[t++] = mat[i][y];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int[][] mat = {
                {1, 2, 3},
                {4, 5, 6}
        };
        int n = mat.length;
        int m = mat[0].length;
        new Main().clockwisePrint(mat, n, m);
        in.close();
    }
}
