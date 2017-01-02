package 无判断Max;

/**
 * Created by h on 16-12-21.
 */
public class Solution {
    public int getMax(int a, int b) {
        // write code here
        int c = a - b;
        boolean signc = sign(c);
        if(signc){
            return b;
        } else {
            return a;
        }
    }

    private boolean sign(int c) {
        return ((c >> 31) & 1) == 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getMax(127102,51621));
    }
}
