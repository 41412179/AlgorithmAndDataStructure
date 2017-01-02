package 滑动窗口的最大值;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        ArrayList<Integer> res = new ArrayList<>();
        if (size == 0) {
            return res;
        }
        int len = num.length;
        for (int i = 0; i < len; i++) {
            if (ad.isEmpty()) {
                ad.addLast(i);
            } else {
                if (num[ad.getLast()] > num[i]) {
                    ad.addLast(i);
                } else {
                    while (!ad.isEmpty() && num[ad.getLast()] < num[i]) {
                        ad.removeLast();
                    }
                    ad.addLast(i);
                }
            }
            if (i >= size - 1) {
                int start = i - (size - 1);
                while (!ad.isEmpty() && ad.getFirst() < start) {
                    ad.pop();
                }
                res.add(num[ad.getFirst()]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] num = {10, 14, 12, 11};
        ArrayList<Integer> res = new Solution().maxInWindows(num, 1);
        for (Integer i :
                res) {
            System.out.println(i);
        }
    }
}
