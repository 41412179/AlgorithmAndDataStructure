package LuckyString;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by h on 16-12-28.
 */
public class Main {

    private static HashSet<Integer> hsFibo = new HashSet<>();

    static {
        //最先被初始化的块
        //System.out.println("hello");
        int a = 1;
        int b = 1;
        hsFibo.add(1);
        for (int i = 0; i < 100; i++) {
            int c = a + b;
            if (c <= 100)
                hsFibo.add(c);
            else break;
            a = b;
            b = c;
        }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        HashSet<String> hs = new HashSet<>();
        while (in.hasNext()) {
            String s = in.next();
            int len = s.length();
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < len + 1; j++) {
                    String sub = s.substring(i, j);
                    hs.add(sub);
                }
            }
            String[] res = new String[hs.size()];
            int t = 0;
            Iterator<String> iterator = hs.iterator();
            while (iterator.hasNext()) {
                //System.out.println(iterator.next());
                res[t++] = iterator.next();
            }
            Arrays.sort(res);
            for (int i = 0; i < res.length; i++) {
                if (fibo(res[i])) {
                    System.out.println(res[i]);
                }
            }
        }
        in.close();
    }

    private static boolean fibo(String s) {
        char ch = '1';
        int len = s.length();
        int num = 0;
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        s = new String(chars);
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) != ch) {
                num++;
                ch = s.charAt(i);
            }
        }
        if (hsFibo.contains(num)) return true;
        else return false;
    }
}
