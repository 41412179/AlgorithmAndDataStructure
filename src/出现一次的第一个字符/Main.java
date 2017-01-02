package 出现一次的第一个字符;

import java.io.BufferedInputStream;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by h on 16-12-28.
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));//多组数据的时候设立缓冲区比较快
        HashMap<Character, Integer> hm = new HashMap<>();
        while (in.hasNext()) {
            int t = in.nextInt();
            for (int i = 0; i < t; i++) {
                String s = in.next();
                int len = s.length();
                for (int j = 0; j < len; j++) {
                    if (hm.get(s.charAt(j)) == null) {
                        hm.put(s.charAt(j), 1);
                    } else {
                        hm.put(s.charAt(j), hm.get(s.charAt(j)) + 1);
                    }
                }
                for (int j = 0; j < len; j++) {
                    if (hm.get(s.charAt(j)) == 1) {
                        System.out.println(s.charAt(j));
                        hm.clear();
                        break;
                    }
                }
            }
        }
        in.close();
    }
}
