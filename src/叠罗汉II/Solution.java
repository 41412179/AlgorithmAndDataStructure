package 叠罗汉II;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public int getHeight(int[][] actors, int n) {
        Arrays.sort(actors, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];// 代表升序
            }
        });
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = 1;
            for (int j = 0; j < i; j++) {
                if (actors[i][1] > actors[j][1]) {
                    if (res[i] < res[j] + 1) {
                        res[i] = res[j] + 1;
                    }
                }
            }
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.max(res[i], ans);
        }
        return ans;
    }

    public static void main(String[] args) {
    }
}
