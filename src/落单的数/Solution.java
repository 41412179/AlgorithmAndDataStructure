package 落单的数;

public class Solution {

    public int singleNumber(int[] A) {
        // Write your code here
        int ans = 0;
        for (int i : A) {
            ans ^= i;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 1, 2};
        System.out.println(new Solution().singleNumber(A));
    }

}
