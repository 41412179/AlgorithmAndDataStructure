package 拜访;

/**
 * Created by h on 16-12-26.
 */
public class Solution {
    public int countPath(int[][] map, int n, int m) {
        int startX = 0;
        int startY = 0;
        int endX = 0;
        int endY = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    startX = i;
                    startY = j;
                }
                if (map[i][j] == 2) {
                    endX = i;
                    endY = j;
                }
            }
        }
        int[][] dp = new int[n][m];
        if (startX == endX || startY == endY) return 1;
        //one
        if (startX > endX && startY < endY) {
            return processOne(startX, startY, endX, endY, map, dp);
        }
        if (startX < endX && startY > endY) {
            startX ^= endX;
            endX ^= startX;
            startX ^= endX;
            startY ^= endY;
            endY ^= startY;
            startY ^= endY;
            return processOne(startX, startY, endX, endY, map, dp);
        }
        //another
        if (startX < endX && startY < endY) {
            startX ^= endX;
            endX ^= startX;
            startX ^= endX;
            startY ^= endY;
            endY ^= startY;
            startY ^= endY;
            return processAnother(startX, startY, endX, endY, map, dp);
        }

        if (startX > endX && startY > endY) {
            return processAnother(startX, startY, endX, endY, map, dp);
        }
        return 1;
    }

    private int processAnother(int startX, int startY, int endX, int endY, int[][] map, int[][] dp) {
        for (int i = startX - 1; i >= endX; i--) {
            if (map[i][startY] != -1) {
                dp[i][startY] = 1;
            } else {
                break;
            }
        }
        for (int i = startY - 1; i >= endY; i--) {
            if (map[startX][i] != -1) {
                dp[startX][i] = 1;
            } else {
                break;
            }
        }
        for (int i = startX - 1; i >= endX; i--) {
            for (int j = startY - 1; j >= endY; j--) {
                if (map[j][i] == 0 || map[j][i] == 2) {
                    if (j - 1 >= 0) dp[j][i] += dp[j - 1][i];
                    if (i - 1 >= 0) dp[j][i] += dp[j][i - 1];
                }
            }
        }
        return dp[endX][endY];
    }

    private int processOne(int startX, int startY, int endX, int endY, int[][] map, int[][] dp) {
        //set bound
        for (int i = startX - 1; i >= endX; i--) {
            if (map[startY][i] != -1) {//row is stable, and col is change
                dp[startY][i] = 1;
            } else {
                break;
            }
        }

        for (int i = startY + 1; i <= endY; i++) {
            if (map[i][startX] != -1) {
                dp[i][startX] = 1;
            } else {
                break;
            }
        }

        for (int i = startX - 1; i >= endX; i--) {
            for (int j = startY + 1; j <= endY; j++) {
                if (map[j][i] == 0 || map[j][i] == 2) {
                    if (j - 1 >= 0) dp[j][i] += dp[j - 1][i];
                    if (i - 1 >= 0) dp[j][i] += dp[j][i - 1];
                }
            }
        }
        return dp[endX][endY];
    }

    public static void main(String[] args) {
        int[][] map = new int[][]{
                {0, 1, 0},
                {2, 0, 0}
        };
        int n = map.length;
        int m = map[0].length;
        System.out.println(new Solution().countPath(map, n, m));
    }
}
