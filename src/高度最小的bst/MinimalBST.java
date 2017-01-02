package 高度最小的bst;

public class MinimalBST {

    public int buildMinimalBST(int[] vals) {
        // write code here
        int len = vals.length;
        int height = 0;
        while (len != 0) {
            len /= 2;
            height++;
        }
        return height;
    }

    public static void main(String[] args) {
        int[] vals = {1, 2, 3, 4};
        System.out.println(new MinimalBST().buildMinimalBST(vals));
    }

}
