package 表示数值的字符串;

public class Solution {
    public boolean isNumeric(char[] str) {
        return false;
    }

    public static void main(String[] args) {
        String s = "+100";
        System.out.println(new Solution().isNumeric(s.toCharArray()));
    }
}
