package 空格替换;

public class Replacement {

    public String replaceSpace(String iniString, int length) {
        // write code here
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            char ch = iniString.charAt(i);
            if (ch == ' ') {
                sb.append('%');
                sb.append('2');
                sb.append('0');
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();

    }

    public static void main(String[] args) {

    }

}
