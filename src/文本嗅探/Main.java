package 文本嗅探;

import java.util.Scanner;

/**
 * Created by h on 16-12-28.
 */
public class Main {
    public int[] containKeyword(String[] A, int n, String[] keys, int m) {
        int[] tmp = new int[n];
        int t = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i].contains(keys[j])) {
                    tmp[t++] = i;
                    break;
                }
            }
        }
        int[] res = null;
        if (t == 0) {
            res = new int[1];
            res[0] = -1;
            return res;
        } else {
            res = new int[t];
            for (int i = 0; i < t; i++) {
                res[i] = tmp[i];
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] A = {"uauqsesb", "uwywfprxptxpmgqwuphqtd", "yibhwmzltswkoxmslparsggkakblrghmflnurwmcyrgburmx", "ngidwcvnxxcyaeiahagxywwodqpixtkboigxdfqoqjgcwizj", "mixlhfnqlunpnbtorov", "wdwcqseyoopvuicakehitqdtz", "eivqoollveiyuxgwzinihcqrjlfmscfkligkfhmmbp", "oicotgbgrzswvbquxqogbpmff", "luifkizyznhseoyforvfzopcudkyofpvkrfyrk", "ahvyasyoxhrnjbfslmgdyrgfontvufxqq", "gjxyfwqmxczwzecdkjwxkcsmjrbevszwfnubyzlshslslfjiqsatsq", "wsbslwfrhpjexfmphkbhfwpeflaujhuoztshhiwpfzunx", "upmqjvoywvcpbhmmrhqhursosxl", "jjjkcxkbvmhzzrz", "dkdvqryuufjrosrzl", "pzprmccuq", "ijiinpcnhuleqxhmpgcvyzgkg", "esopsgamiuzyxtyzvcrtwkotiiakrargihlpsx", "cmct", "jqajtvesmuiaxbcgrakttzbywclanbjvawfzn", "jxgdbjob", "aub", "ejwaihklobckvglgdhhjhomfzlfumkavrmelfmaodd", "mqswknxf"};
        int n = A.length;
        String[] keys = {"z", "s", "h", "e", "th", "b", "e", "qo"};
        int m = keys.length;
        int[] res = new Main().containKeyword(A, n, keys, m);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
        in.close();
    }
}
