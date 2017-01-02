package 加法替换运算;

/**
 * Created by h on 16-12-17.
 */
public class SolutionAns {
    public static void main(String[] args) {
        System.out.println(new SolutionAns().calc(7133, 2, 1));
    }

    public int calc(int a, int b, int type) {
        // write code here
        int ans = 0;
        //如果是乘法
        if (type == 1) {
            for (int i = 1; i <= b; i++) {
                ans += a;
            }
            return ans;
        } else {
            //如果是除法
            if (type == 0) {
                if (a < b)
                    return 0;
                if (a == b) {
                    return 1;
                }

                for (int i = 1; ; i++) {
                    ans += b;
                    if (ans > a) {
                        return i - 1;
                    }
                    if (ans == a) {
                        return i;
                    }
                }
            } else {
                //如果是减法
                if (a > b) {
                    for (int i = 1; ; i++) {
                        b += 1;
                        if (a == b)
                            return i;
                    }
                } else {
                    if (a == b) {
                        return 0;
                    } else {
                        for (int i = 1; ; i++) {
                            a += 1;
                            if (a == b)
                                return -i;
                        }
                    }
                }
            }
        }
    }
}
