package 合法括号判断;

import java.util.Stack;

public class Solution {

    public boolean chkParenthesis(String A, int n) {
        // write code here
        int len = A.length();
        Stack<Character> s = new Stack<Character>();
        for (int i = 0; i < len; i++) {
            Character ch = A.charAt(i);
            if (s.isEmpty()) {
                if (ch == '(') {
                    s.push(ch);
                } else {
                    return false;
                }
            } else {
                if (ch == '(') {
                    s.push(ch);
                } else {
                    if (ch == ')') {
                        if (s.peek() == '(') {
                            s.pop();
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
            }
        }
        return s.isEmpty();
    }

    public static void main(String[] args) {

    }

}
