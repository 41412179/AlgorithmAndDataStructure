package 串的模式匹配;

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
            if (next[i-1] < 0 || P.charAt(i - 1) == P.charAt(next[i - 1])) {
                next[i] = next[i - 1] + 1;
            } else {
                next[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        String A = "djkfkdjfkldjfldj";
        int lenA = A.length();
        String B = "fk";
        int lenB = B.length();
        System.out.println(new Solution().findAppearance(A, lenA,B,lenB));
    }
}
