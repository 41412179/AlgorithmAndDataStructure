package 添加回文串;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by h on 16-12-28.
 */
public class Main {
    public String addToPalindrome(String A, int n) {
        String B = new StringBuilder(A).reverse().toString();
        int len = A.length();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (isPalindrome(A.substring(i, len))) {
                return new StringBuilder(res).reverse().toString();
            } else {
                res.append(A.charAt(i));
            }
        }
        return "";
    }

    private boolean isPalindrome(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        String A = "bbabbaaabba";
        System.out.println(new Main().addToPalindrome(A, A.length()));
        in.close();
    }
}
