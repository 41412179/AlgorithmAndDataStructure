package 最小的k个数;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Solution {
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    ArrayList<Integer> res = new ArrayList<Integer>();

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if (input == null) {
            return res;
        }
        int len = input.length;
        for (int i = 0; i < len; i++) {
            pq.add(input[i]);
        }
        if (pq.size() >= k) {
            for (int i = 0; i < k; i++) {
                res.add(pq.poll());
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
