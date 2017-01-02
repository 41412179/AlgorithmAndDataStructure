package 翻转单词顺序;

/**
 * Created by h on 16-12-25.
 */
public class Solution {
    public String ReverseSentence(String str) {
        String ss = " " + str + " ";
        char[] chars = ss.toCharArray();
        int len = chars.length;
        reverse(chars, 0, len);
        System.out.println(chars);
        int low = 0;
        int high = 0;
        if (chars[0] == ' ') {
            while (true) {
                if(low >= len){
                    break;
                }
                if (low < len && chars[low] == ' ') {
                    low++;
                } else {
                    //low 被确定后
                    high = low;
                    while (high < len) {
                        if (chars[high] != ' ')
                            high++;
                        else {
                            reverse(chars, low, high);
                            low = high;
                            break;
                        }
                    }
                }
            }
        }
        //System.out.println(new String(chars).substring(1, len -1));
        return new String(chars).substring(1, len -1);
    }

    private void reverse(char[] chars, int low, int high) {
        for (int i = low; i < (low + high) / 2; i++) {
            chars[i] ^= chars[low + high - i - 1];
            chars[low + high - i - 1] ^= chars[i];
            chars[i] ^= chars[low + high - i - 1];
        }
    }

    public static void main(String[] args) {
        new Solution().ReverseSentence("i am a student");
    }
}
