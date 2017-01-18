package 奶牛家族;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * Created by h on 16-12-28.
 */
public class Main {
    final static int mod = 1000000007;

    public int countSum(int n) {
        int f1 = 1;
        int f2 = 2;
        int f3 = 3;
        if (n <= 4) return n;
        n -= 3;
        int[][] base = {{1, 2, 3}};
        int[][] matrix = {
                {0, 0, 1},
                {1, 0, 0},
                {0, 1, 1}
        };
        int[][] tmp = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };
        int[][] tmp1 = matrixMlu(matrix, n);
        return mltHelp(base, tmp1)[0][2];
    }

    private int[][] matrixMlu(int[][] matrix, int n) {
        if (n == 1) {
            return matrix;
        }
        if (n % 2 == 1) {
            return mltHelp(matrix, matrixMlu(matrix, n - 1));
        } else {
            int[][] tmp = matrixMlu(matrix, n / 2);
            return mltHelp(tmp, tmp);
        }
    }

    private int[][] mltHelp(int[][] a, int[][] b) {
        int[][] res = new int[3][3];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int k = 0; k < a[i].length; k++) {
                    res[i][j] += (int) (((long) a[i][k] * (long) b[k][j]) % mod);
                    res[i][j] %= mod;
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        System.out.println(new Main().countSum(6));
        in.close();
    }
}
