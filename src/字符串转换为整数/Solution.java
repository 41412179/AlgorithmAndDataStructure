package 字符串转换为整数;

/**
 * Created by h on 16-12-25.
 */
public class Solution {
    public int StrToInt(String str) {
        if(str == null || str.equals("")){
            return 0;
        }
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        String sMax = String.valueOf(max);
        String sMin = String.valueOf(min);
        sMin = sMin.substring(1, sMin.length());
        if (str.charAt(0) == '+') {
            return process(str, sMax);
        } else {
            if (str.charAt(0) == '-') {
                return - process(str, sMin);
            } else {
                char ch = str.charAt(0);
                if (ch <= '9' && ch >= '0') {
                    return process("+" + str, sMax);
                } else {
                    return 0;
                }
            }
        }
    }

    private int process(String str, String sMax) {
        String tmp = str.substring(1, str.length());
        if (tmp.length() <= sMax.length()) {
            for (int i = 0; i < tmp.length(); i++) {
                if (tmp.charAt(i) <= '9' && tmp.charAt(i) >= '0') {
                    continue;
                } else {
                    return 0;
                }
            }
            if (tmp.compareTo(sMax) <= 0) {
                int ans = 0;
                for (int i = 0; i < tmp.length(); i++) {
                    ans = (tmp.charAt(i) - '0') + ans * 10;
                }
                return ans;
            } else {
                return 0;
            }
        } else {
            return 0;
        }

    }

    public static void main(String[] args) {
        System.out.println(new Solution().StrToInt("-123"));
    }
}
