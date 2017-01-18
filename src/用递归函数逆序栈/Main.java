package 用递归函数逆序栈;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * Created by h on 16-12-28.
 */
public class Main {
    public int[] reverseStackRecursively(int[] stack, int top) {
        int[] res = new int[top];
        reverseHelp(stack, top - 1, res, 0);
        return res;
    }

    private void reverseHelp(int[] stack, int i, int[] res, int start) {
        if (i != -1) {
            res[start++] = stack[i];
            reverseHelp(stack, i - 1, res, start);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        while (in.hasNext()) {

        }
        in.close();
    }
}
