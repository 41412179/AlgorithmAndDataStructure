package 最短排序;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by h on 16-12-28.
 */
public class Main {
    public int findShortest(int[] A, int n) {
        int len = A.length;
        int[] B = new int[len];
        System.arraycopy(A, 0, B, 0, len);
        Arrays.sort(A);
        int left = -1;
        for (int i = 0; i < len; i++) {
            if (A[i] != B[i]) {
                left = i;
                break;
            }
        }
        int right = -1;
        for (int i = len - 1; i >= 0; i--) {
            if (A[i] != B[i]) {
                right = i;
                break;
            }
        }
        if (left == -1) return 0;
        return right - left + 1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        while (in.hasNext()) {

        }
        in.close();
    }
}
