package 小米git;

import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * Created by h on 16-12-28.
 */
public class Main {

    public int getSplitNode(String[] matrix, int indexA, int indexB) {
        ArrayDeque<Integer> adA = new ArrayDeque<>();
        ArrayDeque<Integer> adB = new ArrayDeque<>();
        ArrayDeque<Integer> middlePath = new ArrayDeque<>();
        middlePath.addLast(0);
        int len = matrix.length;
        while (!middlePath.isEmpty()) {
            int val = middlePath.pollLast();
            for (int i = 0; i < len; i++) {
                int x = matrix[val].charAt(i) - '0';
                if (x == 1) {

                }
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {

        }
        in.close();
    }
}
