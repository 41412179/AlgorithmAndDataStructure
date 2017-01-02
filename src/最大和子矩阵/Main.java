package 最大和子矩阵;

public class Main {

    public int sumOfSubMatrix(int[][] mat, int n) {
        // write code here
        int[] add = new int[n];
        int[] res = new int[n];
        //int t = 0;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                for (int t = 0; t < n; t++) {
                    for (int k = i; k <= j; k++) {
                        add[t] += mat[k][t];
                    }
                }
                res[0] = add[0];
                for (int h = 1; h < n; h++) {
                    if (res[h - 1] < 0) {
                        res[h] = add[h];
                    } else {
                        res[h] = res[h - 1] + add[h];
                    }
                }
                for (int h = 0; h < n; h++) {
                    ans = Math.max(ans, res[h]);
                    add[h] = 0;
                }

            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // write your code here
        int[][] mat = {
                {1, 2, -3},
                {3, 4, -5},
                {-5, -6, -7}};
        int n = mat.length;
        System.out.print(new Main().sumOfSubMatrix(mat, n));
    }
}
