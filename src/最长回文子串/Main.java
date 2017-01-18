package 最长回文子串;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * Created by h on 16-12-28.
 */
public class Main {
    public int getLongestPalindrome(String A, int n) {
        char[] chars = new char[2 * n + 1];
        for (int i = 0; i < 2 * n + 1; i++) {
            if (i % 2 == 0) chars[i] = '#';
            else chars[i] = A.charAt(i / 2);
        }
        int[] rl = new int[2 * n + 1];
        rl[0] = 1;
        int pos = 0;
        int maxRight = 0;
        int len = 2 * n + 1;
        for (int i = 1; i < 2 * n + 1; i++) {
            if (i > maxRight) {
                rl[i] = 1;
                for (int j = i - 1; j >= 0 && (2 * i - j < len); j--) {
                    if (chars[j] == chars[2 * i - j]) {
                        rl[i]++;
                        maxRight = 2 * i - j;
                        pos = i;
                    } else {
                        break;
                    }
                }
            } else {
                int j = 2 * pos - i;
                int val = rl[j];
                if (j + val)
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        while (in.hasNext()) {

        }
        in.close();
    }
}
