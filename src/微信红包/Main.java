package 微信红包;

import java.util.Scanner;

/**
 * Created by h on 16-12-28.
 */
public class Main {

    public int getValue(int[] gifts, int n) {
        // write code here
        int ans = 1;
        int res = gifts[0];
        for (int i = 1; i < n; i++) {
            if (gifts[i] == gifts[i - 1]) {
                ans++;
            } else {
                if (ans > 1) ans--;
                if (ans == 1) res = gifts[i];
            }
        }
        int num = 0;
        for (int i = 0; i < n; i++) {
            if(gifts[i] == res){
                num++;
            }
        }
        if(num > (n / 2)) return res;
        else return 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {

        }
        in.close();
    }
}
