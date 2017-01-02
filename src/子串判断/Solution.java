package 子串判断;

/**
 * Created by h on 16-12-18.
 */
public class Solution {
    public int findAppearance(String A, int lena, String B, int lenb) {
        int[] next = new int[lenb];
        buildNext(next, B, lenb);
        int i = 0;
        int j = 0;
        while (true) {
            if (i == lena && j != lenb) {
                break;
            }
            if (j == lenb) {
                return i - j;
            }
            if (j < 0 || A.charAt(i) == B.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        return -1;
    }

    private void buildNext(int[] next, String P, int lenP) {
        next[0] = -1;
        for (int i = 1; i < lenP; i++) {
            if (next[i - 1] < 0 || P.charAt(i - 1) == P.charAt(next[i - 1])) {
                next[i] = next[i - 1] + 1;
            } else {
                next[i] = 0;
            }
        }
    }

    public boolean[] chkSubStr(String[] p, int n, String s) {
        // write code here
        boolean[] res = new boolean[n];
        int lena = s.length();
        for (int i = 0; i < n; i++) {
            int lenb = p[i].length();
            if (-1 != findAppearance(s, lena, p[i], lenb)) {
                res[i] = true;
            } else {
                res[i] = false;
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
