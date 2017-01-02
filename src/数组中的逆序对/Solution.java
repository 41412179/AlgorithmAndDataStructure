package 数组中的逆序对;

import java.util.Scanner;

/**
 * Created by h on 16-12-28.
 */
public class Solution {
    public static final int mod = 1000000007;

    public int InversePairs(int[] array) {
        return inversePairsHelp(array, 0, array.length);
    }

    //归并排序适合不可修改
    private int inversePairsHelp(int[] array, int start, int end) { //[start, end)
        if (end - start <= 1) {
            return 0;
        }

        int middle = (start + end) / 2;
        int leftArrayLen = middle - start;
        int[] leftArray = new int[leftArrayLen];
        int rightArrayLen = end - middle;
        int[] rightArray = new int[rightArrayLen];

        System.arraycopy(array, 0, leftArray, 0, leftArrayLen);
        System.arraycopy(array, middle, rightArray, 0, rightArrayLen);

        int leftNum = inversePairsHelp(leftArray, 0, leftArrayLen);
        int rightNum = inversePairsHelp(rightArray, 0, rightArrayLen);
        int res = 0;
        int j = 0;
        int t = 0;
        for (int i = 0; i < middle; i++) {
            int val = leftArray[i];
            if (j < rightArrayLen && val <= rightArray[j]) {
                array[t++] = val;
                j %= mod;
                res += j;
                res %= mod;
                continue;
            } else {
                // val > rightArray[j]
                while (j < rightArrayLen && val > rightArray[j]) {
                    array[t++] = rightArray[j];
                    j++;
                }
                j %= mod;
                res += j;
                res %= mod;
                array[t++] = leftArray[i];
            }
        }
        for (int i = j; i < rightArrayLen; i++) {
            array[t++] = rightArray[i];
        }
        return ((((res % mod) + (leftNum % mod)) % mod) + (rightNum % mod)) % mod;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] array = {3, 6, 2, 4, 7, 8, 1, 9, 5, 0};//3+5+2+2+3+3+1+2+1
        System.out.println(new Solution().InversePairs(array));
        in.close();
    }
}
