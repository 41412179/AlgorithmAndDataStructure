package 合并表记录;

import java.io.BufferedInputStream;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by h on 16-12-28.
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        Map<Integer, Integer> ms = new TreeMap<>();
        while (in.hasNext()) {
            ms.clear();
            int n = in.nextInt();
            for (int i = 0; i < n; i++) {
                int key = in.nextInt();
                int val = in.nextInt();
                if (ms.get(key) != null) {
                    ms.put(key, ms.get(key) + val);
                    continue;
                } else {
                    ms.put(key, val);
                }
            }
            for (Integer i :
                    ms.keySet()) {
                System.out.println(i + " " + ms.get(i));
            }
        }
        in.close();
    }
}
