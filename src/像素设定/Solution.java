package 像素设定;

/**
 * Created by h on 16-12-17.
 */
public class Solution {
    public int[] renderPixel(int[] screen, int x, int y) {
        // write code here
        for (int i = x; i <= y; i++) {
            int num = i / 8;
            int bit = i % 8;
            screen[num] |= (1 << bit);
        }
        return screen;
    }

    public static void main(String[] args) {

    }
}
