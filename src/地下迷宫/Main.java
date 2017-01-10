package 地下迷宫;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * Created by h on 16-12-28.
 */
public class Main {

    private static int max = Integer.MAX_VALUE;
    private static String ans = null;
    private static int[][] map = new int[10][10];
    private static boolean[][] visited = new boolean[10][10];

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        while (in.hasNext()) {
            max = Integer.MIN_VALUE;
            ans = null;
            int n = in.nextInt();
            int m = in.nextInt();
            int p = in.nextInt();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    map[i][j] = in.nextInt();
                    visited[i][j] = false;
                }
            }
            visited[0][0] = true;
            String res = "[0,0]";
            dfs(0, 0, n, m, p, res);
            if (ans == null) {
                System.out.println("Can not escape!");
            } else {
                System.out.println(ans);
            }
        }
        in.close();
    }

    private static void dfs(int x, int y, int n, int m, int p, String res) {
        if (x == 0 && y == m - 1) {
            if (p > max) {
                max = p;
                ans = res;
            }
        }
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        for (int i = 0; i < 4; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];
            if (xx < n && xx > -1 && yy < m && yy > -1 && (map[xx][yy] != 0) && !visited[xx][yy]) {
                int pp = p;
                if (i == 2 || i == 3) {//to right
                    pp = p - 1;
                }
                if (i == 0) {
                    pp = p - 3;
                }
                if (pp >= 0) {
                    visited[xx][yy] = true;
                    dfs(xx, yy, n, m, pp, res + "," + "[" + xx + "," + yy + "]");
                    visited[xx][yy] = false;
                }
            }
        }
    }
}
