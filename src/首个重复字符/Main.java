package 首个重复字符;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by h on 16-12-28.
 */
public class Main {

    public char findFirstRepeat(String A, int n) {
        // write code here
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char ch = A.charAt(i);
            if(hm.get(ch) == null){
                hm.put(ch, 1);
            } else {
                return ch;
            }
        }
        return ' ';

    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {

        }
        in.close();
    }
}
