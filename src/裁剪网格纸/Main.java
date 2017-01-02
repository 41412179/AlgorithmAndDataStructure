package 裁剪网格纸;

import java.util.Scanner;

/**
 * Created by h on 16-12-28.
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int xMin = Integer.MAX_VALUE;
            int xMax = Integer.MIN_VALUE;
            int yMin = Integer.MAX_VALUE;
            int yMax = Integer.MIN_VALUE;

            for (int i = 0; i < n; i++) {
                int x = in.nextInt();
                int y = in.nextInt();
                if (x < xMin) {
                    xMin = x;
                }
                if (x > xMax) {
                    xMax = x;
                }
                if (y < yMin) {
                    yMin = y;
                }
                if (y > yMax) yMax = y;
            }
            long tmp = (long)Math.max(xMax - xMin, yMax - yMin);
            System.out.println(tmp*tmp);
        }
        in.close();
    }
}
