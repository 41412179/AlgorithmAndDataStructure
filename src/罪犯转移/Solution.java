package 罪犯转移;

import java.util.Scanner;

/**
 * Created by h on 16-12-27.
 */
public class Solution {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] seq = new int[2 * 100000 + 1];
        while (in.hasNext()) {
            int n, t, c;
            n = in.nextInt();
            t = in.nextInt();
            c = in.nextInt();
            for (int i = 0; i < n; i++) {
                seq[i] = in.nextInt();
            }
            if (c > n) {
                System.out.println(0);
                continue;
            }
            int sum = 0;

            for (int i = 0; i < c; i++) {
                sum += seq[i];
            }
            int ans = 0;
            for (int i = c; i <= n; i++) {
                if (sum <= t)
                    ans++;
                sum -= seq[i - c];
                sum += seq[i];
            }
            System.out.println(ans);
        }
        in.close();
    }
}
