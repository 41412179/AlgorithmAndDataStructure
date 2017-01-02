package 棋子翻转;

/**
 * Created by h on 16-12-22.
 */
public class Solution {
    public int[][] flipChess(int[][] A, int[][] f) {
        // write code here

        for (int i = 0; i < 3; i++) {
            int x = f[i][0] - 1;
            int y = f[i][1] - 1;
            int[] dx = {0, 0, -1, 1};
            int[] dy = {1, -1, 0, 0};
            for (int j = 0; j < 4; j++) {
                if (x + dx[j] < 4 && x + dx[j] >= 0 && y + dy[j] < 4 && y + dy[j] >= 0) {
                    A[x + dx[j]][y + dy[j]] ^=1;
                }
            }
        }
        return A;
    }
}
