package 确定字符互异;

import java.util.*;

public class Different {
    public boolean checkDifferent(String iniString) {
        if (iniString == null) {
            return true;
        }
        int len = iniString.length();
        if (len == 0) {
            return true;
        }
        char[] str = iniString.toCharArray();
        Arrays.sort(str);
        for (int i = 0; i < len - 1; i++) {
            if (str[i] == str[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Different().checkDifferent("acbdesy"));
    }
}
