package 二维数组打印;

import java.util.Scanner;

/**
 * Created by h on 16-12-28.
 */
public class Main {
    public int[] arrayPrint(int[][] arr, int n) {
        int[] res = new int[n * n];
        int[] t = new int[1];
        t[0] = 0;
        for (int i = n - 1; i >= 0; i--) {
            int x = 0;
            int y = i;
            res[t[0]++] = arr[x][y];
            fill(t, x, y, n, arr, res);
        }
        for (int i = 1; i < n; i++) {
            int x = i;
            int y = 0;
            res[t[0]++] = arr[x][y];
            fill(t, x, y, n, arr, res);
        }
        return res;
    }

    private void fill(int[] t, int x, int y, int n, int[][] arr, int[] res) {
        while (true) {
            x++;
            y++;
            if (x < n && y < n) {
                res[t[0]++] = arr[x][y];
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int n = arr.length;
        int[] res = new Main().arrayPrint(arr, n);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        in.close();
    }
}
