package 判断两个字符串是否互为旋转词;

public class Solution {

    public boolean checkReverseEqual(String s1, String s2) {
        // write code here
        if (s1.length() != s2.length()) {
            return false;
        }
        String x = s2 + s2;
        return x.indexOf(s1) != -1;
    }

    public static void main(String[] args) {

    }

}
