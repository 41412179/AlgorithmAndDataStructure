package 敏感词;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * Created by h on 16-12-28.
 */
public class Main {


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        while (in.hasNext()) {
            int n = in.nextInt();
            String[] ss = new String[n];
            int[] ll = new int[n];
            for (int i = 0; i < n; i++) {
                ss[i] = in.next().toLowerCase();
                ll[i] = ss[i].length();
            }
            in.nextLine();
            String s = in.nextLine();
            int len = s.length();
            char[] res = new char[len];
            for (int i = 0; i < len; i++) {
                res[i] = s.charAt(i);
            }
            s = s.toLowerCase();
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < n; j++) {
                    int l = ll[j];
                    if (i + l <= len) {
                        if (s.substring(i, i + l).equals(ss[j])) {
                            for (int k = i; k < i + l; k++) {
                                res[k] = '*';
                            }
                        }
                    }
                }
            }
            System.out.println(new String(res));
        }
        in.close();
    }
}
