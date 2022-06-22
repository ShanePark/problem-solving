package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

public class Q31NextPermutation2 {

    @Test
    public void test() {

        int[] arr6 = new int[]{1, 1};
        nextPermutation(arr6);
        assertThat(arr6).containsExactly(1,1);

        int[] arr5 = new int[]{1, 3, 2};
        nextPermutation(arr5);
        assertThat(arr5).containsExactly(2, 1, 3);

        int[] arr = {1, 2, 3};
        nextPermutation(arr);
        assertThat(arr).containsExactly(1, 3, 2);

        int[] arr2 = new int[]{3, 2, 1};
        nextPermutation(arr2);
        assertThat(arr2).containsExactly(1, 2, 3);

        int[] arr3 = new int[]{1, 1, 5};
        nextPermutation(arr3);
        assertThat(arr3).containsExactly(1, 5, 1);

        int[] arr4 = new int[]{2, 3, 1};
        nextPermutation(arr4);
        assertThat(arr4).containsExactly(3, 1, 2);

    }

    public void nextPermutation(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int max = -1;
        int length = nums.length;

        for (int i = length - 1; i >= 0; i--) {
            int num = nums[i];
            if (pq.isEmpty() || max <= num) {
                pq.offer(num);
                max = Math.max(max, num);
            } else {
                int j = i;
                pq.offer(num);
                while (num >= pq.peek()) {
                    nums[++j] = pq.poll();
                }
                nums[i] = pq.poll();
                while (!pq.isEmpty()) {
                    nums[++j] = pq.poll();
                }
                return;
            }
        }

        // reverse array
        for (int i = 0; i < length / 2; i++) {
            int tmp = nums[i];
            nums[i] = nums[length - 1 - i];
            nums[length - 1 - i] = tmp;
        }
    }

}
