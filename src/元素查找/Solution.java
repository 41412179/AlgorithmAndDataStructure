package 元素查找;

import java.util.Arrays;

/**
 * Created by h on 16-12-21.
 */
public class Solution {
    public int findElement(int[] A, int n, int x) {
        //return findElementHelp(A, 0, n - 1, x);
        if (n == 1) {
            return 0;
        } else {
            if (n == 2) {
                if (A[0] == x) {
                    return 0;
                } else {
                    return 1;
                }
            }
        }
        if (A[0] < A[n - 1]) {
            return Arrays.binarySearch(A, 0, n, x);
        }
        int left = 0;
        int right = n;

        if (A[0] < A[1]) {//先升后升，（注意不是先升后降）
            while (left < right) {
                int mid = (left + right) / 2;
                if (mid != 0 && mid != (n - 1) && A[mid] > A[mid + 1] && A[mid - 1] < A[mid]) {//如果找到拐点
                    return Math.max(Arrays.binarySearch(A, 0, mid + 1, x), Arrays.binarySearch(A, mid + 1, n, x));
                } else {
                    if (A[mid] > A[0]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
            }
        } else {
            while (left < right) {
                int mid = (left + right) / 2;
                if (mid != 0 && mid != (n - 1) && A[mid] < A[mid + 1] && A[mid - 1] > A[mid]) {//如果找到拐点
                    return Math.max(
                            downBinarySearch(A, 0, mid + 1, x),
                            Arrays.binarySearch(A, mid + 1, n, x));
                } else {
                    if (A[mid] > A[n - 1]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
            }
        }
        return -1;
    }

    private int downBinarySearch(int[] A, int left, int right, int x) {

        while (left < right) {
            int mid = (left + right) / 2;
            if (A[mid] == x) {
                return mid;
            } else {
                if (A[mid] < x) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] A = {13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int n = A.length;
        int x = 18;
        System.out.println(new Solution().findElement(A, n, x));
    }
}
