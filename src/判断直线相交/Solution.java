package 判断直线相交;

public class Solution {
    static double a = Math.pow(10, -6);

    public boolean checkCrossLine(double s1, double s2, double y1, double y2) {
        // write code here
        return Math.abs(s1 - s2) > Math.pow(10, -6) || Math.abs(y1 - y2) < Math.pow(10, -6);
    }

    public static void main(String[] args) {
        // return Math.abs(s1 - s2 > Math.pow(10, -6)) || (Math.abs(y1 - y2) <
        // Math.pow(10, -6));
    }

}
