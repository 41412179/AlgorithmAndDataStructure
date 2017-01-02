package 矩阵相乘;

import java.util.Scanner;

/**
 * Created by h on 16-12-28.
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 0, m = 0;
        int[][] map = null;
        while (in.hasNext()) {
            n = in.nextInt();
            m = in.nextInt();
            map = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    map[i][j] = in.nextInt();
                }
            }
            int[][] leftToRight = new int[n][m];
            int[][] rightToLeft = new int[n][m];
            int[][] upToDown = new int[n][m];
            int[][] downToUp = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (j == 0) {
                        leftToRight[i][j] = map[i][j];
                    } else {
                        leftToRight[i][j] = leftToRight[i][j - 1] * map[i][j];
                    }
                    if (j == 0) {
                        rightToLeft[i][m - j - 1] = map[i][m - j - 1];
                    } else {
                        rightToLeft[i][m - j - 1] = rightToLeft[i][m - j] * map[i][m - j - 1];
                    }
                    if (i == 0) {
                        upToDown[i][j] = map[i][j];
                    } else {
                        upToDown[i][j] = map[i][j] * upToDown[i - 1][j];
                    }
                    if (i == 0) {
                        downToUp[n - i - 1][j] = map[n - i - 1][j];
                    } else {
                        downToUp[n - i - 1][j] = map[n - i - 1][j] * downToUp[n - i][j];
                    }
                }
            }
            int max = -1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int val = 1;
                    if (j - 1 >= 0) val *= leftToRight[i][j - 1];
                    if (j + 1 < m) val *= rightToLeft[i][j + 1];
                    if (i - 1 >= 0) val *= upToDown[i - 1][j];
                    if (i + 1 < n) val *= downToUp[i + 1][j];
                    max = Math.max(max, val);
                }
            }
            System.out.println(max);
        }
        in.close();
    }
}
