package 咋金花;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by h on 16-12-28.
 */
public class Main {

    private static final String[] map = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        while (in.hasNext()) {
            String a = in.next();
            String b = in.next();
            if (illegal(a) || illegal(b)) {
                System.out.println(-2);
                continue;
            }
            int res = win(a, b);
            if (res > 0) System.out.println(1);
            if (res < 0) System.out.println(-1);
            if (res == 0) System.out.println(0);
        }
        in.close();
    }

    private static int win(String a, String b) {
        if (isLeopard(a)) {
            if (isLeopard(b)) {
                return compare_(a, b);
            } else {
                return 1;
            }
        } else {
            if (isShunzi(a) && isShunzi(b)) return compare_(a, b);
            if (isShunzi(a)) return 1;
            if (isShunzi(b)) return -1;
            if (isPair(a) && isPair(b)) return compare_(a, b);
            if (isPair(a)) return 1;
            if (isPair(b)) return -1;
            return compare_(a, b);
        }
    }

    private static boolean isPair(String a) {
        int aLen = a.length();
        int[] aCard = new int[3];
        int t = 0;
        for (int i = 0; i < aLen; i++) {
            if (a.charAt(i) == '1') {
                aCard[t++] = 8;
                i++;
            } else {
                for (int j = 0; j < map.length; j++) {
                    if (a.substring(i, i + 1).equals(map[j])) {
                        aCard[t++] = j;
                    }
                }
            }
        }
        Arrays.sort(aCard);
        int count = 0;
        for (int i = 1; i < aCard.length; i++) {
            if (aCard[i] == aCard[i - 1]) {
                count++;
            }
        }
        if (count == 1) return true;
        return false;
    }

    private static boolean isShunzi(String a) {
        int aLen = a.length();
        int[] aCard = new int[3];
        int t = 0;
        for (int i = 0; i < aLen; i++) {
            if (a.charAt(i) == '1') {
                aCard[t++] = 8;
                i++;
            } else {
                for (int j = 0; j < map.length; j++) {
                    if (a.substring(i, i + 1).equals(map[j])) {
                        aCard[t++] = j;
                    }
                }
            }
        }
        Arrays.sort(aCard);
        if (aCard[0] + 1 == aCard[1] && aCard[1] + 1 == aCard[2]) return true;
        return false;
    }

    private static int compare_(String a, String b) {
        int aLen = a.length();
        int[] aCard = new int[3];
        int t = 0;
        for (int i = 0; i < aLen; i++) {
            if (a.charAt(i) == '1') {
                aCard[t++] = 8;
                i++;
            } else {
                for (int j = 0; j < map.length; j++) {
                    if (a.substring(i, i + 1).equals(map[j])) {
                        aCard[t++] = j;
                    }
                }
            }
        }
        int bLen = b.length();
        int[] bCard = new int[3];
        t = 0;
        for (int i = 0; i < bLen; i++) {
            if (b.charAt(i) == '1') {
                bCard[t++] = 8;
                i++;
            } else {
                for (int j = 0; j < map.length; j++) {
                    if (b.substring(i, i + 1).equals(map[j])) {
                        bCard[t++] = j;
                    }
                }
            }
        }
        Arrays.sort(aCard);
        Arrays.sort(bCard);
        if (isPair(a) && isPair(b)) {
            int aPairId = -1;
            int aNotPair = -1;
            int i = 0;
            if (aCard[0] == aCard[1]) i = 0;
            else i = 2;
            aPairId = aCard[i];
            aNotPair = aCard[2 - i];

            int bPairId = -1;
            int bNotPair = -1;
            if (bCard[0] == bCard[1]) i = 0;
            else i = 2;
            bPairId = bCard[i];
            bNotPair = bCard[2 - i];
            if (aPairId > bPairId) return 1;
            if (aPairId < bPairId) return -1;
            if (aNotPair > bNotPair) return 1;
            if (aNotPair < bNotPair) return -1;
            return 0;
        }
        for (int i = 2; i >= 0; i--) {
            if (aCard[i] < bCard[i]) {
                return -1;
            } else {
                if (aCard[i] > bCard[i]) {
                    return 1;
                }
            }
        }
        return 0;
    }

    private static boolean isLeopard(String b) {
        int len = b.length();
        if (len == 3 || len == 6) {
            if (same(b)) {
                return true;
            } else return false;
        }
        return false;
    }

    private static boolean same(String b) {
        int len = b.length();
        if (len == 3) {
            for (int i = 1; i < len; i++) {
                if (!b.substring(i, i + 1).equals(b.substring(i - 1, i))) {
                    return false;
                }
            }
            return true;
        } else {
            for (int i = 2; i < len; i += 2) {
                if (!b.substring(i, i + 2).equals(b.substring(i - 2, i))) {
                    return false;
                }
            }
            return true;
        }
    }

    private static boolean illegal(String s) {
        int len = s.length();
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '1') {
                if (s.charAt(i + 1) == '0') {
                    i++;
                    count++;
                }
            } else {
                boolean flag = false;
                for (int j = 0; j < map.length; j++) {
                    if (s.substring(i, i + 1).equals(map[j])) {
                        flag = true;
                        count++;
                    }
                }
                if (!flag) return true;
            }
        }
        if (count != 3) return true;
        return false;
    }
}
