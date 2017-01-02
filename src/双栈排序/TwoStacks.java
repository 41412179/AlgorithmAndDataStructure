package 双栈排序;

import java.util.*;

public class TwoStacks {

    public ArrayList<Integer> twoStacksSort(int[] numbers) {
        // write code here
        Stack<Integer> number = new Stack<Integer>();
        for (int i : numbers) {
            number.add(i);
        }
        Stack<Integer> help = new Stack<Integer>();
        while (!number.isEmpty()) {
            int val = number.pop();
            if (help.isEmpty()) {
                help.push(val);
            } else {
                int helpVal = help.peek();
                if (val <= helpVal) {
                    help.push(val);
                } else {
                    while (!help.isEmpty()) {
                        if (val > help.peek()) {
                            number.push(help.pop());
                        } else {
                            help.push(val);
                            break;
                        }
                    }
                    if (help.isEmpty()) {
                        help.push(val);
                    }
                }
            }
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        while (!help.isEmpty()) {
            number.push(help.pop());
        }
        while (!number.isEmpty()) {
            res.add(number.pop());
        }
        return res;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 3, 2, 6, 4, 8, 7};
        ArrayList<Integer> res = new TwoStacks().twoStacksSort(numbers);
        for (Integer i : res) {
            System.out.print(i + " ");
        }
    }
}
