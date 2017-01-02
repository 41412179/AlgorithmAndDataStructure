package 矩阵元素查找;

public class Solution {

    public int[] findElement(int[][] mat, int n, int m, int x) {
        // write code here
        int[] res = new int[2];
        int row = 0;
        int col = m - 1;
        while (true) {
            if (mat[row][col] == x) {
                res[0] = row;
                res[1] = col;
                return res;
            } else {
                if (mat[row][col] > x) {
                    col--;
                    continue;
                } else {
                    row++;
                    continue;
                }
            }
        }
        //return res;
    }

    public static void main(String[] args) {

    }

}
