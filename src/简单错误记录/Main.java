package 简单错误记录;

import java.io.BufferedInputStream;
import java.util.*;

class ErrorLog {
    String filename = null;
    String codeLine = null;

    ErrorLog(String filename, String codeLine) {
        this.filename = filename;
        this.codeLine = codeLine;
    }
}

class Val {
    static int index = 0;
    int id = 0;
    int num = 1;

    Val() {
        index++;
        id = index;
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        HashMap<ErrorLog, Val> hms = new HashMap<ErrorLog, Val>();
        while (in.hasNext()) {
            String s = in.next();
            String codeLine = in.next();
            int len = s.length();
            for (int i = len - 1; i >= 0; i--) {
                if (s.charAt(i) == '\\') {
                    s = s.substring(i + 1, len);
                    break;
                }
            }
            boolean flag = false;
            for (ErrorLog el :
                    hms.keySet()) {
                if (el.filename.equals(s) && el.codeLine.equals(codeLine)) {
                    flag = true;
                    hms.get(el).num++;
                    break;
                }
            }
            if (!flag) {
                hms.put(new ErrorLog(s, codeLine), new Val());
            }
        }

        LinkedList<ErrorLog> res = new LinkedList<>();
        for (ErrorLog el :
                hms.keySet()) {
            boolean change = false;
            for (int i = 0; i < res.size(); i++) {
                Val a = hms.get(el);
                Val b = hms.get(res.get(i));
                if (a.num > b.num) {
                    res.add(i, el);
                    change = true;
                    break;
                } else {
                    if (a.num == b.num) {
                        if (a.id < b.id) {
                            change = true;
                            res.add(i, el);
                            break;
                        }
                    }
                }
            }
            if (!change) {
                res.add(el);
            }
        }
        for (int i = 0; i < 8 && i < res.size(); i++) {
            ErrorLog el = res.get(i);
            String s1 = el.filename;
            if (s1.length() > 16) {
                s1 = s1.substring(s1.length() - 16, s1.length());
            }
            System.out.println(s1 + " " + el.codeLine + " " + hms.get(el).num);
        }
        in.close();
    }
}
