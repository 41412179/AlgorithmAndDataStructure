package 变位词排序;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by h on 16-12-20.
 */
public class Solution {
    public ArrayList<String> sortStrings(String[] str, int n) {
        // write code here
        ArrayList<String> res = new ArrayList<String>();
        HashSet<String> hs = new HashSet<String>();
        for (int i = 0; i < str.length; i++) {
            char[] chars = str[i].toCharArray();//对于原数组中的每个字符串
            Arrays.sort(chars);//排序
            if (!hs.add(new String(chars))) {//如果set中存在该字符串，说明res中有个变位相同的字符串
                int size = res.size();
                for (int j = 0; j < size; j++) {//找到该变位词，并决定留哪个。
                    String s = new String(res.get(j));
                    if (s.length() == str[i].length()) {//如果长度相同，就有可能相同
                        char[] tmp = s.toCharArray();
                        Arrays.sort(tmp);
                        String newString = new String(tmp);
                        if (newString.equals(new String(chars))) {
                            if (s.compareTo(str[i]) > 0) {
                                res.set(j, new String(str[i]));
                                break;
                            }
                        }
                    }
                }
            } else {
                res.add(new String(str[i]));
            }
        }
        Collections.sort(res);
        return res;
    }

    public static void main(String[] args) {
        String[] str = {"emmaldzsvjggzfoda", "skmjhsm", "zjwmkgufsvwrwyvrhk", "am", "vyksgrwwjmwrhzfvuk", "wfszrykvjrmuwhkvgw", "kwrwuwjvksyvhmrzfg", "kom", "gjmqdrzqzjeemxxn", "qqxedgjjmrznmxez", "xxgmjezerjnqmzdq", "vwcmmngdsvzx", "xvmdvwscgnmz", "kpu", "kpu", "a"};
        int n = str.length;
        ArrayList<String> res = new Solution().sortStrings(str, n);
        for (String s : res) {
            System.out.println(s);
        }
    }

}
