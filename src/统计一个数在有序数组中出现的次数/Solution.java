package 统计一个数在有序数组中出现的次数;

public class Solution {
    public int GetNumberOfK(int[] array, int k) {
        int len = array.length;
        if (0 == len) {
            return 0;
        }
        int res = 0;
        int mid = len / 2;
        if (mid >= 0) {
            int midVal = array[mid];
            if (midVal == k) {
                res = 1;
                for (int i = mid - 1; i >= 0; i--) {
                    if (array[i] == k) {
                        res++;
                    } else {
                        break;
                    }
                }
                for (int i = mid + 1; i < len; i++) {
                    if (array[i] == k) {
                        res++;
                    } else {
                        break;
                    }
                }
                return res;
            } else {
                if (midVal > k) {
                    int[] newArray = new int[mid];
                    for (int i = 0; i < mid; i++) {
                        newArray[i] = array[i];
                    }
                    return GetNumberOfK(newArray, k);
                } else {
                    int[] newArray = new int[len - (mid + 1)];
                    for (int i = mid + 1; i < len; i++) {
                        newArray[i - (mid + 1)] = array[i];
                    }
                    return GetNumberOfK(newArray, k);
                }
            }
        } else {
            return res;
        }
    }

    public static void main(String[] args) {
        int[] x = {3};
        System.out.println(new Solution().GetNumberOfK(x, 3));
    }
}