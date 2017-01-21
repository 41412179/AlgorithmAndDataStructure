package 数字键盘;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * Created by h on 16-12-28.
 */
public class Main {

    private static final int[][] map =
            {
                    {0},
                    {0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
                    {0, 2, 3, 5, 6, 8, 9},
                    {3, 6, 9},
                    {0, 4, 5, 6, 7, 8, 9},
                    {0, 5, 6, 8, 9},
                    {6, 9},
                    {0, 7, 8, 9},
                    {0, 8, 9},
                    {9}};

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        while (in.hasNext()) {
            int t = in.nextInt();
            for (int i = 0; i < t; i++) {
                String s = in.next();
                int len = s.length();
                StringBuilder res = new StringBuilder();
                res.append(s.charAt(0));
                int start = 1;
                int before = start - 1;
                while (true) {
                    if (start < len) {
                        if (exist(s, start)) {
                            before++;
                            start++;
                            res.append(s.charAt(before));
                            continue;
                        } else {
                            int val = canReplace(s, start);
                            if (val == -1) {
                                while (true) {
                                    if (start == -1) {
                                        res.append((char) (s.charAt(start) - '1'));
                                        fill(res, s.charAt(start), s.length() - start);
                                        break;
                                    } else {
                                        if (start - 1 >= 0) res.deleteCharAt(start - 1);
                                        int bbefore = start - 2;
                                        if (bbefore >= 0) {
                                            int flag = -1;
                                            for (int j = 0; j < map[s.charAt(bbefore) - '0'].length; j++) {
                                                if (map[s.charAt(bbefore) - '0'][j] < (s.charAt(bbefore + 1) - '0')) {
                                                    flag = map[s.charAt(bbefore) - '0'][j];
                                                }
                                            }
                                            if (flag != -1) {
                                                res.append((char) (flag + '0'));
                                                fill(res, (char) (flag + '0'), s.length() - bbefore - 2);
                                                break;
                                            } else {
                                                start--;
                                                continue;
                                            }
                                        } else {
                                            char ch = (char) (s.charAt(0) - '1' + '0');
                                            res.append(ch);
                                            fill(res, ch, s.length() - 1);
                                            break;
                                        }
                                    }
                                }
                                break;
                            } else {
                                res.append((char) (val + '0'));
                                fill(res, (char) (val + '0'), len - start - 1);
                                break;
                            }
                        }
                    } else break;
                }
                System.out.println(res.toString());
            }
        }
        in.close();
    }

    private static void fill(StringBuilder res, char start, int fillLen) {
        int val = 0;
        if (fillLen > 0)
            val = start - '0';
        for (int i = 0; i < fillLen; i++) {
            res.append((char) (map[val][map[val].length - 1] + '0'));
            val = map[val][map[val].length - 1];
        }
    }

    private static int canReplace(String s, int start) {
        int before = start - 1;
        int beforeNum = s.charAt(before) - '0';
        int len = map[beforeNum].length;
        for (int i = len - 1; i >= 0; i--) {
            if (map[beforeNum][i] < (int) (s.charAt(start) - '0')) {
                return map[beforeNum][i];
            }
        }
        return -1;
    }

    private static boolean exist(String s, int start) {
        int before = start - 1;
        int beforeNum = s.charAt(before) - '0';
        int len = map[beforeNum].length;
        for (int i = 0; i < len; i++) {
            if (map[beforeNum][i] == (s.charAt(start) - '0')) {
                return true;
            }
        }
        return false;
    }
}
