package 整数对查找;

import java.util.HashMap;

public class Solution {
    public int countPairs(int[] A, int n, int sum) {
        // write code here
        HashMap<Integer, Integer> hms = new HashMap<Integer, Integer>();
        HashMap<Integer, Boolean> visited = new HashMap<Integer, Boolean>();
        for (int i :
                A) {
            if (hms.containsKey(i)) {
                hms.put(i, hms.get(i)+1);
            } else {
                hms.put(i, 1);
                visited.put(i, false);
            }
        }
        int ans = 0;
        for (Integer i:
             hms.keySet()) {
            if(!visited.get(i)) {
                int another = sum - i;
                if (another == i) {
                    int num = hms.get(i);
                    ans += (num - 1) * num / 2;
                } else {
                    if (hms.containsKey(another)) {
                        ans += hms.get(i) * hms.get(another);
                        visited.put(another,true);
                    } else {
                        continue;
                    }
                }
            }
            visited.put(i, true);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {11,7,7,6,14,2,14,15,2,1,2,12,13,9,8,15,13,8,10,11,14,10,2,9,4,9,3,7,6,10,15,4,7,6,15,3,9,13,5,2,6,10,10,1,12,4,3,3,8,8,1,4,7,11,13,5,13,15,4,3,1,11,6,11,9,9,11,15,12,10,13,3,11,4,8,9,7,3,13,9,11,3,2,11,10,1,4,2,3,3,14,11,5,10,1,14,8,1,11,3,1,9,14,6,1,7,15,10,14,6,4,12,11};
        int n = A.length;
        int sum = 16;
        System.out.println(new Solution().countPairs(A, n, sum));
    }
}
