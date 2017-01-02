package 左移字符串;

public class Solution {
    public String LeftRotateString(String str, int n) {
        if (str == null) {
            return str;
        }
        int len = str.length();
        if (len == 0) {
            return str;
        }

        n = n % len;
        return str.substring(n, len) + str.substring(0, n);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().LeftRotateString("dfjk", 4));
    }
}
