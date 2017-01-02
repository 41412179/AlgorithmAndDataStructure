package 字符流中第一个不重复的字符;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    HashMap<Character, Integer> hms = new HashMap<Character, Integer>();
    // Insert one char from stringstream
    Queue<Character> q = new LinkedList<Character>();

    public void Insert(char ch) {
        if (hms.containsKey(ch)) {
            hms.put(ch, hms.get(ch) - 1);
        } else {
            hms.put(ch, -1);
            q.add(ch);
        }
    }

    // return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        if (q.isEmpty()) {
            return '#';
        }
        while (!q.isEmpty()) {
            char ch = q.peek();
            if (hms.get(ch) < -1) {
                q.poll();
            } else {
                return ch;
            }
        }
        return '#';
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.FirstAppearingOnce());
        s.Insert('g');
        s.Insert('o');
        System.out.println(s.FirstAppearingOnce());
        s.Insert('o');
        s.Insert('g');
        System.out.println(s.FirstAppearingOnce());
        s.Insert('l');
        s.Insert('e');
        System.out.println(s.FirstAppearingOnce());

    }
}