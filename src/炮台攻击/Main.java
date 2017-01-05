package 炮台攻击;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * Created by h on 16-12-28.
 */
public class Main {


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        double[] coordinate = new double[8];
        double R = 0;
        while (in.hasNext()) {
            R = in.nextDouble();
            for (int i = 0; i < 8; i++) {
                coordinate[i] = in.nextDouble();
            }
            int res = 0;
            for (int i = 0; i < 6; i += 2) {
                if (Math.pow(coordinate[i] - coordinate[6], 2.0) +
                        Math.pow(coordinate[i + 1] - coordinate[7], 2.0) <= R * R) {
                    res++;
                }
            }
            System.out.println(res + "x");
        }
        in.close();
    }
}
