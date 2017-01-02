package 位运算实现加法;

public class Solution {
    public int Add(int num1, int num2) {
        return num2 == 0 ? num1 : Add(num1 ^ num2, (num1 & num2) << 1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().Add(2, 3));
    }
}
