package 压缩字符串;

public class Zipper {

    public String zipString(String iniString) {
        // write code here
        char[] str = iniString.toCharArray();
        int len = str.length;
        char last = 0;
        int size = 0;

        for (int i = 0; i < len; i++) {
            if (str[i] != last) {
                last = str[i];
                size++;
            }
        }
        if (size * 2 >= len) {
            return iniString;
        }
        char[] resCh = new char[size];

        int[] ch = new int[size];
        last = 0;
        int cur = -1;
        for (int i = 0; i < len; i++) {
            if (str[i] != last) {
                cur++;
                resCh[cur] = str[i];// 得到结果字符
                ch[cur]++;// 得到每个字符出现的次数
                last = str[i];
            } else {
                ch[cur]++;
            }
        }
        char[] res = new char[size * 2];
        int t = 0;
        for (int i = 0; i < size * 2; i++) {
            if ((i & 1) == 0)
                res[i] = resCh[i / 2];
            else {
                res[i] = (char) (ch[i / 2] + 48);
            }
        }
        return String.valueOf(res);
    }

    public static void main(String[] args) {
        System.out.println(new Zipper().zipString("aabcccccaaa"));
    }

}
