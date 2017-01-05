package 血型遗传检测;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by h on 16-12-28.
 */

public class Main {
    public String[] chkBlood(String father, String mother) {
        if (father.compareTo(mother) > 0) {
            String s = father;
            father = mother;
            mother = s;
        }
        LinkedList<String> ld = new LinkedList<>();
        if (father.equals("A")) {
            if (mother.equals("A")) {
                ld.add("A");
                ld.add("O");
            } else {
                if (mother.equals("B")) {
                    ld.add("A");
                    ld.add("AB");
                    ld.add("B");
                    ld.add("O");
                } else {
                    if (mother.equals("AB")) {
                        ld.add("A");
                        ld.add("AB");
                        ld.add("B");
                    } else {
                        ld.add("A");
                        ld.add("O");
                    }
                }
            }
        } else {
            if (father.equals("AB")) {
                if (mother.equals("AB")) {
                    ld.add("A");
                    ld.add("AB");
                    ld.add("B");
                } else {
                    if (mother.equals("B")) {
                        ld.add("A");
                        ld.add("AB");
                        ld.add("B");
                    } else {
                        ld.add("A");
                        ld.add("B");
                    }
                }
            } else {
                if (father.equals("B")) {
                    if (mother.equals("B")) {
                        ld.add("B");
                        ld.add("O");
                    } else {
                        ld.add("B");
                        ld.add("O");
                    }
                } else {
                    if (mother.equals("O")) {
                        ld.add("O");
                    }
                }
            }
        }
        String[] res = new String[ld.size()];
        for (int i = 0; i < ld.size(); i++) {
            res[i] = ld.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        in.close();
    }
}
