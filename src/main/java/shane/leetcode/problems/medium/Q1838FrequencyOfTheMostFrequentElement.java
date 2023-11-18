package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE 58 / 71 testcases passed
 */
public class Q1838FrequencyOfTheMostFrequentElement {

    @Test
    public void test() {
        assertThat(maxFrequency(new int[]{1, 2, 4}, 5)).isEqualTo(3);
        assertThat(maxFrequency(new int[]{1, 4, 8, 13}, 5)).isEqualTo(2);
        assertThat(maxFrequency(new int[]{3, 9, 6}, 2)).isEqualTo(1);
    }

    @Test
    public void tle() {
        int[] arr = new int[100000];
        assertThat(maxFrequency(arr, 5)).isEqualTo(0);
    }

    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        Queue<Number> queue = new LinkedList<>();
        int maxSize = 0;
        for (int num : nums) {
            for (Number n : queue) {
                k -= n.update(num);
            }
            while (k < 0) {
                Number first = queue.poll();
                k += first.release();
            }
            queue.offer(new Number(num));
            maxSize = Math.max(maxSize, queue.size());
        }
        return maxSize;
    }

    class Number {
        int original;
        int cur;

        public Number(int num) {
            this.original = num;
            this.cur = num;
        }

        public int update(int num) {
            int diff = num - cur;
            this.cur = num;
            return diff;
        }

        public int release() {
            return cur - original;
        }
    }

}
