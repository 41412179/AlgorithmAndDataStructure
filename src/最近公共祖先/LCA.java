package 最近公共祖先;

public class LCA {

    public int getLCA(int a, int b) {
        // write code here
        while (a != b) {
            if (a > b) {
                a >>= 1;
            } else {
                b >>= 1;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(new LCA().getLCA(2, 3));
    }

}
