package 约瑟夫环问题I;

public class Solution {

    public int getResult(int n, int m) {
        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = (result + m) % i;
        }
        return result + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getResult(4, 2));
    }
}
