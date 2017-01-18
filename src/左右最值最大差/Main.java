package 左右最值最大差;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * Created by h on 16-12-28.
 */
public class Main {
    public int findMaxGap(int[] A, int n) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (max < A[i]) max = A[i];
        }
        return max - Math.min(A[0], A[n - 1]);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        while (in.hasNext()) {

        }
        in.close();
    }
}
