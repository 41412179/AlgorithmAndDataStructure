package 几大排序算法的学习;

import java.util.Scanner;

/**
 * Created by h on 16-12-28.
 */
public class QuickSort {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] num = new int[100];
        while (in.hasNext()) {
            int n = in.nextInt();
            for (int i = 0; i < n; i++) {
                num[i] = in.nextInt();
            }
            QuickSortFun(num, 0, n);
            for (int i = 0; i < n; i++) {
                System.out.print(num[i] + " ");
            }
            System.out.println();
        }
        in.close();
    }

    private static void QuickSortFun(int[] num, int start, int end) {
        int privot = num[0];
        int i = start + 1;
        int j = end - 1;
        while (i < j) {
            while (i < j && num[i] < privot) {
                i++;
            }
            while (i < j && num[j] > privot) {
                j--;
            }
            if (i < j) {
                num[i] ^= num[j];
                num[j] ^= num[i];
                num[i] ^= num[j];
            }
        }
    }
}
