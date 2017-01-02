package 字符混编;

/**
 * Created by h on 16-12-29.
 */
public class Mixture {
    public boolean chkMixture(String A, int n, String B, int m, String C, int v) {
        return chkMixtureHelp(A, B, C);
    }

    private boolean chkMixtureHelp(String a, String b, String c) {
        if (c.equals("") && a.equals("") && b.equals("")) return true;
        if (c.equals("")) return false;

        char ch = c.charAt(0);
        boolean ansOne = false;
        boolean ansTwo = false;

        if (a.length() > 0 && a.charAt(0) == ch) {
            ansOne = chkMixtureHelp(a.substring(1, a.length()), b, c.substring(1, c.length()));
        }
        if (b.length() > 0 && b.charAt(0) == ch) {
            ansTwo = chkMixtureHelp(a, b.substring(1, b.length()), c.substring(1, c.length()));
        }
        return ansOne || ansTwo;
    }

    public static void main(String[] args) {
        System.out.println(new Mixture().chkMixture("abaacbcababbccccbaababcbbacbaac", 31, "cacbbb", 6, "zjcrmlqwgrsocgnkvafzzeaiixzkmcyqgcmdf", 37));
    }
}
