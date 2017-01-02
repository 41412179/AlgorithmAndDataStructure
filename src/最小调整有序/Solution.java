package 最小调整有序;

/**
 * Created by h on 16-12-18.
 */
public class Solution {
    public int[] findSegment(int[] A, int n) {
        // write code here
        int right = 0;
        int rightMax = A[0];
        int left = 0;
        for (int i = 1; i < n; i++) {
            if (A[i] >= rightMax) {
                rightMax = A[i];
            } else {
                right = i;
            }
        }
        int leftMin = A[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (A[i] > leftMin) {
                left = i;
            } else {
                leftMin = A[i];
            }
        }
        return new int[]{left, right};
    }

    public static void main(String[] args) {

        for (int i :
                new Solution().findSegment(new int[]{1, 4, 6, 5, 9, 10}, 6)) {
            System.out.println(i);
        }
    }
}
