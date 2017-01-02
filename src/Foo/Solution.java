package Foo;

/**
 * Created by h on 16-12-24.
 */
public class Solution {
    void foo(int x) {
        System.out.println(x & -x);
    }

    public static void main(String[] args) {
        new Solution().foo((1 << 31) - 3);
    }
}
