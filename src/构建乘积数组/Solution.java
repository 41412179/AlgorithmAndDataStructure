package 构建乘积数组;

public class Solution {
    public int[] multiply(int[] A) {
        int len = A.length;
        int[] left = new int[len];
        System.arraycopy(A, 0, left, 0, len);
        int[] right = new int[len];
        System.arraycopy(A, 0, right, 0, len);

        for (int i = 1; i < len; i++) {
            left[i] *= left[i - 1];
        }
        for (int i = len - 2; i >= 0; i--) {
            right[i] *= right[i + 1];
        }

        int[] B = new int[len];
        B[0] = right[1];
        B[len - 1] = left[len - 2];
        for (int i = 1; i < len - 1; i++) {
            B[i] = left[i - 1] * right[i + 1];
        }
        return B;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4};
        int[] x = new Solution().multiply(A);
        int len = A.length;
        for (int i = 0; i < len; i++) {
            System.out.println(x[i] + " ");
        }
    }
}