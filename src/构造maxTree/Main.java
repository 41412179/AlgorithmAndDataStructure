package 构造maxTree;

/**
 * Created by h on 17-1-16.
 */
public class Main {
    public int[] buildMaxTree(int[] A, int n) {
        int[] leftToRight = new int[n];
        int[] rightToLeft = new int[n];
        leftToRight[0] = -1;
        for (int i = 1; i < n; i++) {
            if (A[i] < A[i - 1]) {
                leftToRight[i] = i - 1;
            } else {
                int j = i - 1;
                while (true) {
                    if (leftToRight[j] == -1) {
                        leftToRight[i] = -1;
                        break;
                    } else {
                        if (A[leftToRight[j]] < A[i]) {
                            j = leftToRight[j];
                        } else {
                            leftToRight[i] = leftToRight[j];
                            break;
                        }
                    }
                }
            }
        }
        rightToLeft[n - 1] = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (A[i] < A[i + 1]) {
                rightToLeft[i] = i + 1;
            } else {
                int j = i + 1;
                while (true) {
                    if (rightToLeft[j] == -1) {
                        rightToLeft[i] = -1;
                        break;
                    } else {
                        if (A[rightToLeft[j]] < A[i]) {
                            j = rightToLeft[j];
                        } else {
                            rightToLeft[i] = rightToLeft[j];
                            break;
                        }
                    }
                }
            }
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if (leftToRight[i] == -1 && rightToLeft[i] == -1) {
                res[i] = -1;
                continue;
            }
            if (leftToRight[i] == -1) res[i] = rightToLeft[i];
            if (rightToLeft[i] == -1) res[i] = leftToRight[i];
            if (leftToRight[i] != -1 && rightToLeft[i] != -1)
                res[i] = A[leftToRight[i]] < A[rightToLeft[i]] ? leftToRight[i] : rightToLeft[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {340, 1387, 2101, 847, 1660, 733, 36, 528};
        int n = A.length;
        int[] res = new Main().buildMaxTree(A, n);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
