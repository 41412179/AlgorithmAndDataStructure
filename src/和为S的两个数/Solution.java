package 和为S的两个数;

import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int len = array.length;
        int i = 0, j = len - 1;
        while (true) {
            if (i < j) {
                int tmp = array[i] + array[j];

                if (tmp == sum) {
                    res.add(array[i]);
                    res.add(array[j]);
                    break;
                } else {
                    if (tmp > sum) {
                        j--;
                    } else {
                        i++;
                    }
                }
            } else {
                break;
            }
        }
        return res;
    }
}
