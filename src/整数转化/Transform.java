package 整数转化;

public class Transform {

    public int calcCost(int A, int B) {
        // write code here
        int res = A ^ B;
        int count = 0;
        while (res != 0) {
            if ((res & 1) == 1)
                count++;
            res = res & (res - 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Transform().calcCost(-1, 1));
    }

}
