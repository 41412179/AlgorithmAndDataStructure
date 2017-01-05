package 七的个数;

/**
 * Created by haodong on 17-1-4.
 * answer:4000
 */
public class Main {
    public static void main(String[] args) {
        int res = 0;
        for (int i = 0; i <= 100; i++) {
            int j = i;
            while (j > 0) {
                if (j % 10 == 7) {
                    res++;
                }
                j /= 10;
            }
        }
        System.out.println(res);
    }
}
