package 像素翻转;

public class transform {

    public int[][] transformImage(int[][] mat, int n) {
        // 将旋转操作转化为翻转操作，使得代码好写了许多
        int middle = n / 2;
        for (int i = 0; i < middle; i++) {
            // i <--> n-i-1
            for (int j = 0; j < n; j++) {
                int t = n - i - 1;
                mat[i][j] ^= mat[t][j];
                mat[t][j] ^= mat[i][j];
                mat[i][j] ^= mat[t][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int tmp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = tmp;
            }
        }
        return mat;
    }

    public static void main(String[] args) {

    }

}
