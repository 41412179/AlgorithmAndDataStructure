package 实时中位数;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Middle {

    public int[] getMiddle(int[] A, int n) {

        int[] res = new int[n];
        // 小根堆存比较大的一半数
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(n);
        // 大根堆存比较小的一半数
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(n, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                minHeap.add(A[i]);
                if (!maxHeap.isEmpty())
                    if (minHeap.peek() < maxHeap.peek()) {
                        int minUp = minHeap.poll();
                        int maxUp = maxHeap.poll();
                        maxHeap.add(minUp);
                        minHeap.add(maxUp);
                    }
            } else {
                maxHeap.add(A[i]);
                if (!minHeap.isEmpty())
                    if (maxHeap.peek() > minHeap.peek()) {
                        int minUp = minHeap.poll();
                        int maxUp = maxHeap.poll();
                        maxHeap.add(minUp);
                        minHeap.add(maxUp);
                    }
            }
            if (i % 2 == 0) {
                res[i] = minHeap.peek();
            } else {
                res[i] = maxHeap.peek();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {236312, 116289, 257841, 40359, 21993, 121674, 68768, 288444, 98015, 118071, 130963, 221777, 71589, 233048, 89053, 20048, 264772, 141943, 170253, 299901, 193849, 211453, 198250, 280383, 126656, 4775, 229057, 119532};
        int n = A.length;
        for (int i : new Middle().getMiddle(A, n)) {
            System.out.println(i);
        }
    }
}
