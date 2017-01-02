package 找出字符串;

public class Solution {

    public int findString(String[] str, int n, String x) {
        int left = 0, right = n;
        while (true) {
            if (right - left <= 0) {
                break;
            }
            int mid = (left + right) / 2;
            if (str[mid].equals(x)) {
                return mid;
            } else {
                if (str[mid] == "") {
                    for (int i = mid - 1; i >= 0; i--) {
                        if (str[i].equals("")) {
                            continue;
                        } else {
                            if (str[i].compareTo(x) > 0) {
                                right = i;
                                continue;
                            } else {
                                if (str[i].compareTo(x) < 0) {
                                    left = mid + 1;
                                    continue;
                                } else {
                                    return i;
                                }
                            }
                        }
                    }
                } else {
                    if (str[mid].compareTo(x) > 0) {
                        right = mid;
                        continue;
                    } else {
                        left = mid + 1;
                        continue;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] str = {"a", "", "b", "c", "", "", "d"};
        int n = str.length;
        String x = "b";
        System.out.println(new Solution().findString(str, n, x));
    }

}
