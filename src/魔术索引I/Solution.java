package 魔术索引I;

/**
 * Created by h on 16-12-17.
 */
public class Solution {
    public boolean findMagicIndex(int[] A, int n) {
        int left = 0, right = n - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (mid == A[mid]) {
                return true;
            } else {
                if (mid < A[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] A = {0,1,3,5,6};
        int n = A.length;
        System.out.println(new Solution().findMagicIndex(A, n));
    }
}
