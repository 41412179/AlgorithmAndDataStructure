package 二进制小数;

/**
 * Created by h on 16-12-18.
 */
public class Solution {
    public String printBin(double num) {
        // write code here
        if (num > 1 || num < 0) {
            return "Error";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("0.");
        int i = 0;
        for (; i < 32 && (num != 0); i++) {
            num *= 2;
            if (num >= 1) {
                num -= 1;
                sb.append('1');
            } else {
                sb.append('0');
            }
        }
        if(i == 32){
            return "Error";
        } else {
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().printBin(0.625));
    }
}
