package 基本字符串压缩;

/**
 * Created by h on 16-12-26.
 */
public class Solution {
    public String zipString(String iniString) {
        int len = iniString.length();
        StringBuilder sb = new StringBuilder();
        char before = ' ';
        int num = 0;
        for (int i = 0; i < len; i++) {
            char ch = iniString.charAt(i);
            if (before != ch) {
                if (before != ' ') {
                    sb.append(before);
                    sb.append(String.valueOf(num));
                    num = 1;
                    before = ch;
                } else {
                    before = ch;
                    num = 1;
                }
            } else
                num++;
        }
        if(num != 0){
            sb.append(iniString.charAt(len -1));
            sb.append(num);
        }
        String s2= sb.toString();
        int len2 = s2.length();
        if(len2 >= len){
            return iniString;
        } else return s2;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().zipString("aaa"));
    }
}
