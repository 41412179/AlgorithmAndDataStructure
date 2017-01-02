package 另类加法;

/**
 * Created by h on 16-12-17.
 */
public class Solution {
    public int addAB(int A, int B) {
        // write code here
        while (B != 0) {
            int tmp = A & B;
            A ^= B;
            B = tmp << 1;
        }
        return A;
    }

    public static void main(String[] args) {

    }
}
