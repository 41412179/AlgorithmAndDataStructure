package 无序数组中最小的K个数;

import java.util.Arrays;

/**
 * Created by h on 16-12-26.
 */
public class Solution {
    public int[] findKthNumbers(int[] A, int n, int k) {
        int[] B = new int[n];
        System.arraycopy(A, 0, B, 0, n);
        Arrays.sort(B);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            if(B[i] > max){
                max = B[i];
            }
        }
        int[] res = new int[k];
        int t = 0;
        for (int i = 0; i < n; i++) {
            if(A[i]<=max){
                res[t++] = A[i];
            }
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
