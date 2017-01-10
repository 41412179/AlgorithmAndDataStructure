package 回文序列;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * Created by h on 16-12-28.
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int[] seq = new int[50];
        while (in.hasNext()) {
            int n = in.nextInt();
            for (int i = 0; i < n; i++) {
                seq[i] = in.nextInt();
            }
            int left = 0;
            int right = n - 1;
            int ans = 0;
            while (left < right) {
                if (seq[left] < seq[right]) {
                    seq[left + 1] += seq[left];
                    left++;
                    ans++;
                } else {
                    if (seq[left] > seq[right]) {
                        seq[right - 1] += seq[right];
                        right--;
                        ans++;
                    } else {
                        left++;
                        right--;
                    }
                }
            }
            System.out.println(ans);
        }
        in.close();
    }
}
