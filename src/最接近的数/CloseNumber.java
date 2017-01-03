package 最接近的数;

public class CloseNumber {

    public int[] getCloseNumber(int x) {
        int greaterVal = getNext(x);
        int[] res = new int[2];
        int lessVal = getPre(x);
        res[1] = greaterVal;
        res[0] = lessVal;
        return res;
    }

    private int getPre(int x) {
        int n = x;
        int c0 = 0;
        int c1 = 0;
        if ((n & 1) == 1) {

        }
        return 0;
    }

    private int getNext(int x) {
        int c1 = 0;
        int c0 = 0;
        int n = x;
        if ((x & 1) == 1) {
            while ((n & 1) == 1) {
                c1++;
                n >>= 1;
            }
        } else {
            while ((n & 1) == 0) {
                c0++;
                n >>= 1;
            }
            while ((n & 1) == 1) {
                c1++;
                n >>= 1;
            }
        }
        n = n | 1;
        n = n << (c1 + c0);
        int tmp = 1 << (c1 - 1);
        tmp -= 1;
        n = n | tmp;
        return n;
    }

    public static void main(String[] args) {
        int[] res = new CloseNumber().getCloseNumber(4);
        System.out.println(res[1]);
    }

}
