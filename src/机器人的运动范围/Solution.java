package 机器人的运动范围;

import java.util.LinkedList;
import java.util.Queue;

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {

    public int movingCount(int threshold, int rows, int cols) {
        int ans = 0;
        boolean[][] visited = new boolean[rows][cols];
        Queue<Point> q = new LinkedList<Point>();
        q.add(new Point(0, 0));
        int[] xx = {0, 0, -1, 1};
        int[] yy = {1, -1, 0, 0};
        while (!q.isEmpty()) {
            Point p = q.poll();
            visited[p.x][p.y] = true;
            if (numBit(p.x, p.y) <= threshold) {
                ans++;
                for (int i = 0; i < 4; i++) {
                    int x = p.x + xx[i];
                    int y = p.y + yy[i];
                    if ((x >= 0 && x < rows) && (y >= 0 && y < cols) && !visited[x][y]) {
                        q.add(new Point(x, y));
                    }
                }
            }
        }
        return ans;

    }

    private int numBit(int x, int y) {
        int ans = 0;
        while (x != 0) {
            ans += x % 10;
            x /= 10;
        }
        while (y != 0) {
            ans += y % 10;
            y /= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().movingCount(1, 3, 3));
    }

}
