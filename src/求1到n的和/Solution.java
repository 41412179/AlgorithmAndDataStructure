package 求1到n的和;

public class Solution {
    private static int N = 0, sum = 0;

    public Solution() {
        N++;
        sum += N;
    }

    public static int getSum() {
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().Sum_Solution(3));
    }

    public int Sum_Solution(int n) {
        Solution.N = 0;
        Solution.sum = 0;
        for (int i = 0; i < n; i++) {
            new Solution();
        }
        return getSum();
    }
}