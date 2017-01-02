package diamondProblem;

interface W {
    static int a = 1;
}

interface X extends W {
    static int a = 3;
}

class Y implements W {
    static int a = 4;
}

public class Solution extends Y implements X {
    static int a = 5;

    public static void main(String[] args) {
        System.out.println(Solution.a);
    }
}
