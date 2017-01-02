package 数组中只出现一次的数;

public class Solution {
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        int len = array.length;
        int aXorb = 0;
        for (int i = 0; i < len; i++) {
            aXorb ^= array[i];
        }
        int index = 0;// towards left move bits
        int tmp = aXorb;
        for (int i = 0; i <= 31; i++) {
            if (1 == (tmp & 1)) {
                index = i;
                break;
            } else {
                tmp >>= 1;
            }
        }
        // int a = 0;
        num1[0] = 0;
        for (int i = 0; i < len; i++) {
            if (((array[i] >> index) & 1) == 1) {
                num1[0] ^= array[i];
            }
        }
        num2[0] = aXorb ^ num1[0];
        System.out.println(num1[0] + " " + num2[0]);
    }

    public static void main(String[] args) {
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        int[] array = {2, 4, 3, 6, 3, 2, 5, 5};
        new Solution().FindNumsAppearOnce(array, num1, num2);
    }
}
