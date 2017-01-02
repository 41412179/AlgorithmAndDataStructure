package 扑克牌的顺子;

public class Solution {

    public boolean isContinuous(int[] numbers) {

        int len = numbers.length;
        if (len == 0) {
            return false;
        }
        int[] sortArray = new int[14];
        for (int i : numbers) {
            sortArray[i]++;
        }

        for (int i = 0, j = 0; i < 14; i++) {
            while (sortArray[i] != 0) {
                numbers[j++] = i;
                sortArray[i]--;
            }
        }

        int boss = 0;
        for (int i = 0; i < len - 1; i++) {
            // System.out.print(i + " ");
            if (numbers[i] == 0) {
                boss++;
            } else {
                int gap = numbers[i + 1] - numbers[i];
                if (gap == 0) {
                    return false;
                } else {
                    if (gap == 1) {
                        continue;
                    } else {
                        if (boss >= (gap - 1)) {
                            boss -= gap - 1;
                            continue;
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 3, 2, 4};
        System.out.println(new Solution().isContinuous(numbers));
    }
}
