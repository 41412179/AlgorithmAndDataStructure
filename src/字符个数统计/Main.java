package 字符个数统计;

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
            hms.clear();
            String s = in.nextLine();
            int len = s.length();
            for (int i = 0; i < len; i++
                    ) {
                char ch = s.charAt(i);
                if (ch <= 127 && ch >= 0)
                    if (hms.get(ch) == null) {
                        hms.put(ch, 1);
                    }
            }
            int res = 0;
            for (Character ch :
                    hms.keySet()) {
                res++;
            }
            System.out.println(res);
        }
        in.close();
    }
}
