package 和为s的连续正整数序列;

import java.util.ArrayList;

/**
 * Created by h on 16-12-25.
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        int high = 1;
        int low = 1;
        int cur = 1;
        while (high < sum || low > high) {
            if (cur < sum) {
                high++;
                cur += high;
            } else {
                if (cur == sum) {
                    ArrayList<Integer> tmp = new ArrayList<Integer>();
                    for (int i = low; i <= high; i++) {
                        tmp.add(i);
                        //System.out.print(i + " ");
                    }
                    res.add(tmp);
                    //System.out.println();
                    high ++;
                    cur+=high;
                } else {
                    cur -= low;
                    low++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution().FindContinuousSequence(100);
    }
}
