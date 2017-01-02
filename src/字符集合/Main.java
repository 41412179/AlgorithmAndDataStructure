package 字符集合;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by h on 16-12-28.
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder res = null;
        HashMap<Character, Boolean> use = new HashMap<>();
        while (in.hasNext()) {
            String s = in.next();
            res = new StringBuilder();
            use.clear();
            int len = s.length();
            for (int i = 0; i < len; i++) {
                if (!use.containsKey(s.charAt(i))) {
                    res.append(s.charAt(i));
                    use.put(s.charAt(i),true);
                }
            }
            System.out.println(res.toString());
        }
        in.close();
    }
}
