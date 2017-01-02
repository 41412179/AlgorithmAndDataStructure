package 二的个数;

/**
 * Created by h on 16-12-17.
 */
public class Solution {
    public int countNumberOf2s(int n) {
        int ans = 0;
        int tmp = n;
        int bitNum = 0;
        int tail = 1;
        while (tmp != 0) {
            bitNum++;
            tail *= 10;
            tmp /= 10;
        }
        int tmp2 = n;
        while (bitNum >= 3) {
            n%=(tail/10);
        }
        if (n < 100)
            ans = process(n);
        return ans;
    }

    private int process(int n) {
        if (n < 2) {
            return 0;
        } else {
            if (n < 12) {
                return 1;
            } else {
                if (n < 20) {
                    return 2;
                } else {
                    if (n >= 20 && n <= 21) {
                        int difference = n - 19;
                        return difference + 2;
                    } else {
                        if (n == 22) {
                            return 6;
                        } else {
                            if (n <= 29) {
                                return 6 + n - 22;
                            } else {
                                if (n <= 31) {
                                    return 13;
                                } else {
                                    int up = n / 10;
                                    int down = n % 10;
                                    if (down >= 2) {
                                        return up + 12;
                                    } else {
                                        return up + 10;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countNumberOf2s(23));
    }
}
