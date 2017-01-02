package 矩阵中的路径;

/**
 * Created by h on 16-12-25.
 */
public class Solution {

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        boolean[][] visited = new boolean[rows][cols];

        char[][] matrixNew = new char[rows][cols];
        int len = rows * cols;

        for (int i = 0; i < len; i++) {
            matrixNew[i / cols][i % cols] = matrix[i];
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                boolean flag = false;
                if (matrixNew[i][j] == str[0]) {
                    visited[i][j] = true;
                    flag = dfs(i, j, matrixNew, visited, str, 1);
                    if (flag) return true;
                    else {
                        visited[i][j] = false;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(int x, int y, char[][] matrixNew, boolean[][] visited, char[] str, int cur) {
        if (cur == str.length) {
            return true;
        }
        int rows = matrixNew.length;
        int cols = matrixNew[0].length;
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        for (int k = 0; k < 4; k++) {
            int tmpX = x + dx[k];
            int tmpY = y + dy[k];
            if (tmpX < rows && tmpX >= 0 && tmpY < cols && tmpY >= 0) {
                if (!visited[tmpX][tmpY] && str[cur] == matrixNew[tmpX][tmpY]) {
                    visited[tmpX][tmpY] = true;
                    if (dfs(tmpX, tmpY, matrixNew, visited, str, cur + 1)) {
                        return true;
                    } else {
                        visited[tmpX][tmpY] = false;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        String s = "ABCESFCSADEE";
        String str = "ABCB";
        char[] matrix = s.toCharArray();
        char[] ss = str.toCharArray();
        System.out.println(new Solution().hasPath(matrix, 3, 4, ss));
    }
}
