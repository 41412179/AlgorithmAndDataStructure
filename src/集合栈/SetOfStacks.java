package 集合栈;

import java.util.ArrayList;

public class SetOfStacks {

    public ArrayList<ArrayList<Integer>> setOfStacks(int[][] ope, int size) {
        // write code here
        ArrayList<ArrayList<Integer>> set = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> s1 = new ArrayList<Integer>();
        set.add(s1);
        if (ope == null) {
            return set;
        }
        int times = ope.length;
        int curStack = 0;
        for (int i = 0; i < times; i++) {
            int op = ope[i][0];
            int val = ope[i][1];
            if (op == 1) {
                ArrayList<Integer> s = set.get(curStack);
                if (s.size() >= size) {
                    curStack++;
                    ArrayList<Integer> newStack = new ArrayList<Integer>();
                    set.add(newStack);
                    set.get(curStack).add(val);
                } else {
                    set.get(curStack).add(val);
                }
            } else {
                if (set.get(curStack).size() <= 0) {
                    set.remove(curStack);
                    curStack--;
                    set.get(curStack).remove(size - 1);
                } else {
                    ArrayList<Integer> tmp = set.get(curStack);
                    tmp.remove(tmp.size() - 1);
                }
            }
        }
        //System.out.println(set.get(0).size());
        return set;
    }

    public static void main(String[] args) {
        System.out.println(new SetOfStacks().setOfStacks(null, 0));
    }

}
