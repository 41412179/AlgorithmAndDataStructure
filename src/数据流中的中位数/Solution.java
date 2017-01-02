package 数据流中的中位数;

import java.util.HashMap;


public class Solution {
    public int FirstNotRepeatingChar(String str) {
        int len = str.length();
        if (len == 0) {
            return -1;
        }
        HashMap<Character, Integer> nums = new HashMap<Character, Integer>();
        HashMap<Character, Integer> pos = new HashMap<Character, Integer>();


        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            Integer val = nums.get(ch);
            if (val == null) {
                nums.put(ch, 1);
                pos.put(ch, i);
            } else {
                pos.put(ch, -1);
            }
        }
        int res = 10001;
        for (Character ch : pos.keySet()) {
            if (pos.get(ch).intValue() != -1) {
                res = Math.min(res, pos.get(ch));
            }
        }
        if (res == 10001) res = -1;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().FirstNotRepeatingChar("addddddffah"));
    }
}