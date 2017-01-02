package 字符串替换;

import java.util.Scanner;

/**
 * Created by h on 16-12-28.
 */
public class Main {
    public String formatString(String A, int n, char[] arg, int m) {
        int len = A.length();
        StringBuilder res = new StringBuilder();
        int t=0;
        for (int i = 0; i < len; i++) {
            if(i+2<=len && A.substring(i, i+2).equals("%s")){
                res.append(arg[t++]);
                i++;
            }else {
                res.append(A.charAt(i));
            }
        }
        while(m!=t){
            res.append(arg[t++]);
        }
        //System.out.println(res.toString());
        return res.toString();
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String A = "%sab%scd%sdf%s";
        int n = A.length();
        char[] arg = {'3','1','2','4','5'};
        int m = arg.length;
        new Main().formatString(A, n, arg, m);
        in.close();
    }
}
