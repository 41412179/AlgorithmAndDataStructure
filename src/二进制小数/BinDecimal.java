package 二进制小数;

public class BinDecimal {

    public String printBin(double num) {
        double base = 0.5;
        StringBuilder sb = new StringBuilder();
        sb.append("0.");
        while (true) {
            num -= base;
            if (num > 0) {
                sb.append("1");
            } else {
                if (num < 0) {
                    return "Error";
                } else {
                    sb.append("1");
                    return sb.toString();
                }
            }
            base /= 2;
        }
    }

    public static void main(String[] args) {
        System.out.println("");
    }

}
