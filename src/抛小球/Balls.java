package 抛小球;

/**
 * Created by h on 16-12-29.
 */
public class Balls {
    public int calcDistance(int A, int B, int C, int D) {
        double ans = 0;
        ans += process(A);
        ans += process(B);
        ans += process(C);
        ans += process(D);
        return (int)Math.ceil(ans);
    }

    private double process(double a) {
        double res = 0;
        res += a;
        while ((a/2)>0.00000001){
            a/=2;
            res += a*2;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println( (int)(Math.ceil(new Balls().calcDistance(100,90,80,70))));
    }
}
