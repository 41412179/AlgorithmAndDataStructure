package 搬圆桌;

import java.util.Scanner;

/**
 * Created by h on 16-12-28.
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double r, x, y, x1, y1;
        ;

        while (in.hasNext()) {
            r = in.nextDouble();
            x = in.nextDouble();
            y = in.nextDouble();
            x1 = in.nextDouble();
            y1 = in.nextDouble();
            double d = 2 * r;
            double dis = Math.sqrt((x1 - x) * (x1 - x) + (y1 - y) * (y1 - y));
            System.out.println((int)Math.ceil(dis / d));
        }
        in.close();
    }
}
