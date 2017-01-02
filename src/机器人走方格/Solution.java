package 机器人走方格;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by h on 16-12-17.
 */
class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    public int countWays(int[][] map, int x, int y) {
        final int mod = 1000000007;
        if (map[0][0] != 1) {
            return 0;
        }

        int ans = 0;
        int[][] dp = new int[x][y];
        for (int i = 0; i < x; i++) {
            if (map[i][0] == 1)
                dp[i][0] = 1;
            else {
                break;
            }
        }
        for (int i = 0; i < y; i++) {
            if (map[0][i] == 1) {
                dp[0][i] = 1;
            } else {
                break;
            }
        }

        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
                if (map[i][j] == 1) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    dp[i][j] %= mod;
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return dp[x - 1][y - 1];
    }

    public static void main(String[] args) {
        int[][] map = {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };
        //int[][] map
        int x = map.length;
        int y = map[0].length;
        new Solution().countWays(map, x, y);
    }
}
