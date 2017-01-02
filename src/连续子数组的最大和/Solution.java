package 连续子数组的最大和;

public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {

        int len = array.length;
        int maxSum = Integer.MIN_VALUE;
        return Helper(array, array[0], maxSum, 1, len);
    }

    private int Helper(int[] array, int real, int maxSum, int i, int len) {
        if (i == len) {
            return maxSum;
        }
        int val = array[i];
        if (real < 0) {
            real = Math.max(real, val);
            maxSum = Math.max(real, maxSum);

        } else {
            val = val + real;
            if (val >= 0) {
                real = val;
                maxSum = Math.max(real, maxSum);
            } else {
                real = val;

            }
        }
        return Helper(array, real, maxSum, i + 1, len);
    }

    public static void main(String[] args) {
        int[] x = {1, 23};
        System.out.println(new Solution().FindGreatestSumOfSubArray(x));
    }
}
