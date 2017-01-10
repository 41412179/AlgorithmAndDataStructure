package 之字形打印矩阵;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * Created by h on 16-12-28.
 */
public class Main {
    public int[] printMatrix(int[][] mat, int n, int m) {
        int[] res = new int[n * m];
        int t = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < m; j++) {
                    res[t++] = mat[i][j];
                }
            } else {
                for (int j = m - 1; j >= 0; j--) {
                    res[t++] = mat[i][j];
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        while (in.hasNext()) {

        }
        in.close();
    }
}
