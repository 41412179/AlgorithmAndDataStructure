package 魔术索引II;

/**
 * Created by h on 16-12-19.
 */
public class Solution {
    public boolean findMagicIndex(int[] A, int n) {
        return findMagicIndexHelp(A, 0, n-1);
    }

    private boolean findMagicIndexHelp(int[] A, int left, int right) {
        if(left == right){
            if(left == A[left]){
                return true;
            } else {
                return false;
            }
        }
        int mid = 0;
        if (left < right) {
            mid = (left + right) / 2;
            if(mid == A[mid]){
                return true;
            } else {
                return findMagicIndexHelp(A, left,mid -1) || findMagicIndexHelp(A, mid+ 1, right);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,4,5};
        int n = A.length;
        System.out.println(new Solution().findMagicIndex(A, n));
    }
}
