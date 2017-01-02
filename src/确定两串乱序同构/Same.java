package 确定两串乱序同构;

import java.util.HashMap;

public class Same {

    public boolean checkSam(String stringA, String stringB) {
        // write code here
        int sizeA = stringA.length();
        int sizeB = stringB.length();
        if (sizeA != sizeB) {
            return false;
        }
        HashMap<Character, Integer> as = new HashMap<Character, Integer>();
        HashMap<Character, Integer> bs = new HashMap<Character, Integer>();
        for (int i = 0; i < sizeA; i++) {
            char chA = stringA.charAt(i);
            char chB = stringB.charAt(i);
            if (null == as.get(chA)) {
                as.put(chA, 1);
            } else {
                as.put(chA, as.get(chA));
            }
            if (null == bs.get(chB)) {
                bs.put(chB, 1);
            } else {
                bs.put(chB, bs.get(chB));
            }
        }
        for (Character i : as.keySet()) {
            if (as.get(i) != bs.get(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Same().checkSam("dk fj", "dk fj"));
    }

}
