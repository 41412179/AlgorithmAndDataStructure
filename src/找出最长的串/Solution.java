package 找出最长的串;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

/**
 * Created by h on 16-12-20.
 */
public class Solution {
    public int getLongest(String[] str, int n) {
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() < o2.length()) {
                    return 1;
                }
                return -1;
            }
        });
        for (int i = 0; i < str.length; i++) {
            String s = new String(str[i]);
            if (getLongestHelp(str, s, i+1, str.length)) {
                return s.length();
            }
        }
        return 0;

    }

    private boolean getLongestHelp(String[] str, String s, int start, int length) {

        for (int i = start; i < str.length; i++) {

            String newS = new String(str[i]);
            if(newS.length()<s.length()){
                break;
            }
            if (s.equals(newS)) {
                return true;
            }
        }
        boolean flag = false;
        int len = s.length();
        if (len == 1) {
            return flag;
        }
        for (int i = 1; i < len; i++) {
            String left = new String(s.substring(0, i));
            String right = new String(s.substring(i, len));
            if (!flag) flag = getLongestHelp(str, left, start, length) && getLongestHelp(str, right, start, length);
            else break;
        }
        return flag;
    }

    public static void main(String[] args) {
        String[] str = {
                "puwkj","a","j","gc","puwk"
        };
        int n = str.length;
        System.out.println(new Solution().getLongest(str, n));
    }
}
