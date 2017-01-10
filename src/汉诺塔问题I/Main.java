package 汉诺塔问题I;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static final String[] map = {"left", "mid", "right"};

    public ArrayList<String> getSolution(int n) {
        ArrayList<String> res = new ArrayList<>();
        move(res, n, 0, 1, 2);
        return res;
    }

    private void move(ArrayList<String> res, int n, int from, int mid, int to) {
        if (n == 1) {
            res.add("move from " + map[from] + " to " + map[to]);
            return;
        }
        move(res, n - 1, from, to, mid);
        move(res, 1, from, mid, to);
        move(res, n - 1, mid, from, to);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        new Main().getSolution(2);
        in.close();
    }
}
