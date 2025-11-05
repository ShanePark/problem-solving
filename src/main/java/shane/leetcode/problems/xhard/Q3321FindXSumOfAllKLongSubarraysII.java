package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q3321FindXSumOfAllKLongSubarraysII {

    @Test
    public void test() {
        assertThat(findXSum(new int[]{1, 1, 2, 2, 3, 4, 2, 3}, 6, 2)).isEqualTo(new long[]{6, 10, 12});
        assertThat(findXSum(new int[]{3, 8, 7, 8, 7, 5}, 2, 2)).isEqualTo(new long[]{11, 15, 15, 15, 12});
    }

    @Test
    public void tle() {
        int[] arr = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        assertThat(findXSum(arr, 1, 1)).isEqualTo(Arrays.stream(arr).mapToLong(Long::valueOf).toArray());
    }

    public long[] findXSum(int[] nums, int k, int x) {
        Map<Integer, Counter> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            Counter counter = map.getOrDefault(nums[i], new Counter(nums[i]));
            map.put(nums[i], counter);
            counter.plus();
        }

        long[] answer = new long[nums.length - k + 1];
        for (int i = 0; i < answer.length; i++) {
            long sum = map.values().stream()
                    .sorted()
                    .limit(x)
                    .mapToLong(c -> c.num * c.count)
                    .sum();
            answer[i] = sum;

            // remove first
            int removeTarget = nums[i];
            map.get(removeTarget).minus();

            // add next
            if (nums.length == k + i)
                break;
            int num = nums[k + i];
            Counter counter = map.getOrDefault(num, new Counter(num));
            map.put(num, counter);
            counter.plus();
        }

        return answer;
    }

    class Counter implements Comparable<Counter> {
        final int num;
        long count = 0;

        Counter(int num) {
            this.num = num;
        }

        @Override
        public int compareTo(Counter o) {
            if (this.count == o.count)
                return o.num - this.num;
            return Long.compare(o.count, this.count);
        }

        @Override
        public String toString() {
            return "Counter{" +
                    "num=" + num +
                    ", count=" + count +
                    '}';
        }

        public void plus() {
            this.count++;
        }

        public void minus() {
            this.count--;
        }
    }

}
