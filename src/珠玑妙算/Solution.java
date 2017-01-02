package 珠玑妙算;

public class Solution {

    public int[] calcResult(String A, String guess) {
        int guessNum = 0;
        StringBuilder sbA = new StringBuilder();
        StringBuilder sbGuess = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            if (A.charAt(i) == guess.charAt(i)) {
                guessNum++;
            } else {
                sbA.append(A.charAt(i));
                sbGuess.append(guess.charAt(i));
            }
        }
        int persudo = 0;
        int len = sbGuess.length();
        boolean[] visited = new boolean[len];
        for (int i = 0; i < len; i++) {
            char ch = sbGuess.charAt(i);
            for (int j = 0; j < len; j++) {
                if (!visited[j] && ch == sbA.charAt(j)) {
                    persudo++;
                    visited[j] = true;
                    break;
                }
            }
        }
        int[] res = new int[2];
        res[0] = guessNum;
        res[1] = persudo;
        return res;

    }

    public static void main(String[] args) {
        String A = "GBBR";
        String guess = "BYRR";
        new Solution().calcResult(A, guess);
    }

}
