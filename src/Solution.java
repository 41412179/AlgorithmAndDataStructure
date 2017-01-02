import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int GetUglyNumber_Solution(int index) {
        if (index == 0) {
            return 0;
        }

        if (1 == index) {
            return 1;
        }
        Queue<Integer> q2 = new LinkedList<Integer>();
        Queue<Integer> q3 = new LinkedList<Integer>();
        Queue<Integer> q5 = new LinkedList<Integer>();
        q2.add(2);
        q3.add(3);
        q5.add(5);
        int cur = 2, minVal = 0;
        int q2Val, q3Val, q5Val;
        while (cur != (index + 1)) {
            q2Val = q2.peek();
            q3Val = q3.peek();
            q5Val = q5.peek();
            minVal = Math.min(q2Val, Math.min(q3Val, q5Val));
            if (minVal == q2Val) {
                q2.poll();
                q2.add(minVal * 2);
                q3.add(minVal * 3);
                q5.add(minVal * 5);
                cur++;
                continue;
            }

            if (minVal == q3Val) {
                q3.poll();
                q3.add(minVal * 3);
                q5.add(minVal * 5);
                cur++;
                continue;
            }

            if (minVal == q5Val) {
                q5.poll();
                q5.add(minVal * 5);
                cur++;
                continue;
            }
        }
        return minVal;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().GetUglyNumber_Solution(1000));
    }
}