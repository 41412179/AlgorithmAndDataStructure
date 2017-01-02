package 投篮游戏;

import java.util.Scanner;

/**
 * Created by h on 16-12-28.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean[] use = new boolean[301];
        while (in.hasNext()){
            for (int i = 0; i < 301; i++) {
                use[i] = false;
            }
            int p,n;
            p = in.nextInt();
            n = in.nextInt();
            int flag = 1;
            for (int i = 0; i < n; i++) {
                int num = in.nextInt();
                int mod = num % p;
                if(use[mod]){
                    System.out.println(i + 1);
                    for (int j = i +1; j < n; j++) {
                        in.nextInt();
                    }
                    flag = 0;
                    break;
                } else {
                    use[mod] = true;
                }
            }
            if(flag ==1)
            System.out.println(-1);
        }
        in.close();
    }
}
