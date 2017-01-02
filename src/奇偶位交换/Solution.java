package 奇偶位交换;

public class Solution {

    public int exchangeOddEven(int x) {
        return (((x & 0xaaaaaaaa) >>> 1) | ((x & 0x55555555) << 1));
    }

    public static void main(String[] args) {

    }

}
