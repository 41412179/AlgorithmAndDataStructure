package 井字棋;

/**
 * Created by h on 16-12-20.
 */
public class Solution {
    public boolean checkWon(int[][] board) {
        // write code here
        for(int i=0;i<3;i++){
            if(board[i][0] +board[i][1] +board[i][2] == 3 || board[0][i] +board[1][i] +board[2][i] == 3){
                return true;
            }
        }
        if(board[0][0] + board[1][1] + board[2][2] == 3 || board[0][2] + board[1][1] + board[2][0]==3){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {

    }}
