package 一到N中1出现的个数;

/**
 * Created by h on 16-12-25.
 */
public class Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        int ans = 0;
        for (int i = 1; i < n + 1; i++) {
            ans += singleNum(i);
        }
        return ans;
    }

    private int singleNum(int i) {
        int num = 0;
        while (i != 0) {
            boolean flag = ((i % 10) == 1);
            if (flag) num++;
            i/=10;
        }
        return num;
    }

    public static void main(String[] args) {

    }
}
