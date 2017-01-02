package 手写快排;

public class Solution {

    public void sortIntegers2(int[] A) {
        // Write your code here
        int len = A.length;
        quickSort(A, 0, len - 1);
    }

    private void quickSort(int[] R, int low, int high) {
        int pivotpos = 0;
        if (low < high) {
            pivotpos = Partition(R, low, high);
            quickSort(R, low, pivotpos - 1);
            quickSort(R, pivotpos + 1, high);
        }
    }

    private int Partition(int[] r, int low, int high) {

        return 0;
    }

    public static void main(String[] args) {

    }

}
