package 单词最近距离;

/**
 * Created by h on 16-12-17.
 */
public class Solution {
    public int getDistance(String[] article, int n, String x, String y) {
        int xPos = -1;
        int yPos = -1;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < article.length; i++) {
            if (x.equals(article[i])) {
                xPos = i;
                if (yPos != -1) {
                    ans = Math.min(ans, Math.abs(xPos - yPos));
                }
            }
            if (y.equals(article[i])) {
                yPos = i;
                if (xPos != -1) {
                    ans = Math.min(ans, Math.abs(xPos - yPos));
                }
            }

        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
