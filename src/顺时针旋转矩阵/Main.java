package 顺时针旋转矩阵;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * Created by h on 16-12-28.
 */
public class Main {
    public int[][] rotateMatrix(int[][] mat, int n) {
        //先按副对角线翻转，再上下翻转
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int tmp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = tmp;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = mat[i][(n - 1) - j];
                mat[i][(n - 1) - j] = mat[i][j];
                mat[i][j] = tmp;
            }
        }
        return mat;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int[][] mat = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        new Main().rotateMatrix(mat, mat.length);
        in.close();
    }
}
