package 平均年龄;

import java.util.Scanner;

/**
 * Created by h on 16-12-27.
 */
public class Solution {
    //w y x n
    public static void main(String[] args) {
        double w,y,x,n;
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            w = in.nextDouble();
            y = in.nextDouble();
            x = in.nextDouble();
            n = in.nextDouble();

            for(int i=1;i<=n;i++){
                y = (1-x) * (y+1) + 21 * x;
            }
            System.out.println((int)Math.ceil(y));
        }
    }
}
