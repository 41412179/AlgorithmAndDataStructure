package 上楼梯;

public class GoUpstairs {

    private static final int MOD = 1000000007;

    public int countWays(int n) {
        // write code here
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        if (n == 3)
            return 4;
        // 利用三元一次方程组手算的base
        int[][] base = {{1, 1, 0}, {1, 0, 1}, {1, 0, 0}};
        int[][] res = new int[base.length][base[0].length];
        for (int i = 0; i < res.length && i < res[0].length; i++) {
            res[i][i] = 1;
        }
        res = matrixPower(base, n - 3, res);
        //return (4 * res[0][0] + 2 * res[1][0] + res[2][0]) % MOD;
        int[][] a = {{4, 2, 1}};
        res = multiMatrix(a, res);
        return res[0][0];
    }

    private int[][] matrixPower(int[][] base, int n, int[][] res) {
        if (0 == n) {
            return res;
        } else {
            if ((1 & n) == 0) { // 如果n是偶数
                return matrixPower(multiMatrix(base, base), n / 2, res);
            } else {
                return matrixPower(base, n - 1, multiMatrix(res, base));
            }
        }
    }

    private int[][] multiMatrix(int[][] m1, int[][] m2) {
        int[][] res = new int[m1.length][m2[0].length];
        int m1_row = m1.length;
        int m1_col = m1[0].length;
        int m2_col = m2[0].length;
        for (int i = 0; i < m1_row; i++) {
            for (int j = 0; j < m2_col; j++) {
                for (int k = 0; k < m1_col; k++) {
                    long tmp = ((long) (m1[i][k] % MOD) * (long) (m2[k][j] % MOD));
                    long tmp2 = (tmp % (long) MOD);
                    int tmp3 = (int) tmp2;
                    res[i][j] = (tmp3 + res[i][j]) % MOD;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        GoUpstairs go = new GoUpstairs();
        System.out.println(go.countWays(36196));
    }
}
