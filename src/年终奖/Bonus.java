package 年终奖;

/**
 * Created by h on 16-12-29.
 */
public class Bonus {
    public int getMost(int[][] board) {
        int len = 6;
        int[][] res= new int[6][6];
        res[0][0] = board[0][0];
        //set bound
        for (int i = 1; i < len; i++) {
            res[i][0] = res[i-1][0] + board[i][0];
            res[0][i] = res[0][i-1] + board[0][i];
        }
        for (int i = 1; i < len; i++) {
            for (int j = 1; j < len; j++) {
                res[i][j] = Math.max(res[i-1][j], res[i][j-1]) + board[i][j];
            }
        }
        return res[5][5];
    }
    public static void main(String[] args) {

    }
}
