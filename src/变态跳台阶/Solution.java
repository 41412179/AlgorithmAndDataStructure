package 变态跳台阶;

public class Solution {
    static final int MAX = 32;
    static int[] res = new int[MAX];

    static {
        for (int i = 1; i < 31; i++) {
            res[i] = 1 << (i - 1);
        }
    }

    public int JumpFloorII(int target) {
        return res[target];
    }

    public static void main(String[] args) {

        System.out.println(new Solution().JumpFloorII(3));
    }
}
