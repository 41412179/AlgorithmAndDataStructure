package 把数组排成最小的数;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public String PrintMinNumber(int[] array) {
        if (array == null) {
            return null;
        }

        int len = array.length;
        if (len == 0) {
            return "";
        }
        String[] strs = new String[len];
        for (int i = 0; i < len; i++) {
            strs[i] = String.valueOf(array[i]);
        }
        Arrays.sort(strs, new Comparator<String>() {

            @Override
            public int compare(String s1, String s2) {
                String c1 = s1 + s2;
                String c2 = s2 + s1;

                return c1.compareTo(c2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(strs[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 2, 4, 2, 5, 2, 3};
        System.out.println(new Solution().PrintMinNumber(array));
    }
}
