package 多数组K大值;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * Created by h on 16-12-28.
 */
public class Main {
    public int findKthNum(int[] arr1, int[] arr2, int kth) {
        int i = 0;
        int j = 0;
        while (true) {
            if (i < arr1.length && j < arr2.length) {
                if (arr1[i] < arr2[j]) {
                    kth--;
                    if (kth == 0) {
                        return arr1[i];
                    } else {
                        i++;
                    }
                } else {
                    kth--;
                    if (kth == 0) {
                        return arr2[j];
                    } else {
                        j++;
                    }
                }
            }
            if (i < arr1.length && j >= arr2.length) {
                //i++;
                kth--;
                if (kth == 0) {
                    return arr1[i];
                } else {
                    i++;
                }
            }
            if (i >= arr1.length && j < arr2.length) {
                kth--;
                if (kth == 0) {
                    return arr2[j];
                } else {
                    j++;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        while (in.hasNext()) {

        }
        in.close();
    }
}
