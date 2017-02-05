package Main;

import java.io.BufferedInputStream;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by h on 16-12-28.
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        HashMap<Character, Integer> hms = new HashMap<>();
        while (in.hasNext()) {
            String s = in.next();
            hms.clear();
            int len = s.length();
            for (int i = 0; i < len; ) {
                int val = 1;
                int j = 0;
                for (j = i + 1; j < len; j++) {
                    if (s.charAt(j) == s.charAt(i)) {
                        val++;
                    } else break;
                }
                char ch = s.charAt(i);
                if (hms.get(ch) == null) {
                    hms.put(ch, val);
                } else {
                    hms.put(ch, Math.max(hms.get(ch), val));
                }
                i = j;
            }
            int res = 0;
            for (Character ch :
                    hms.keySet()) {
                res += hms.get(ch);
            }
            System.out.println(res);
        }
        in.close();
    }
}
