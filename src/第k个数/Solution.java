package 第k个数;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int GetUglyNumber_Solution(int index) {
        if (index == 0) {
            return 0;
        }
        Queue<Integer> q3 = new LinkedList<Integer>();
        Queue<Integer> q5 = new LinkedList<Integer>();
        Queue<Integer> q7 = new LinkedList<Integer>();

        q3.add(3);
        q5.add(5);
        q7.add(7);
        int cur = 1, minVal = 0;
        int q7Val, q3Val, q5Val;
        while (cur != (index + 1)) {
            q7Val = q7.peek();
            q3Val = q3.peek();
            q5Val = q5.peek();
            minVal = Math.min(q7Val, Math.min(q3Val, q5Val));
            if (minVal == q7Val) {
                q7.poll();

                q7.add(minVal * 7);
                cur++;
                continue;
            }

            if (minVal == q3Val) {
                q3.poll();
                q3.add(minVal * 3);
                q5.add(minVal * 5);
                q7.add(minVal * 7);
                cur++;
                continue;
            }

            if (minVal == q5Val) {
                q5.poll();
                q5.add(minVal * 5);
                q7.add(minVal * 7);
                cur++;
                continue;
            }
        }
        return minVal;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().GetUglyNumber_Solution(2));
    }
}
