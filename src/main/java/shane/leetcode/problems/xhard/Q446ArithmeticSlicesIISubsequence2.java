package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 600 ms Beats 14.2%
 * Memory 162.4 MB Beats 9.14%
 */
public class Q446ArithmeticSlicesIISubsequence2 {

    @Test
    public void test() {
        assertThat(numberOfArithmeticSlices(new int[]{0, 2000000000, -294967296})).isEqualTo(0);
        assertThat(numberOfArithmeticSlices(new int[]{2, 4, 6, 8, 10})).isEqualTo(7);
        assertThat(numberOfArithmeticSlices(new int[]{7, 7, 7, 7, 7})).isEqualTo(16);
    }

    @Test
    public void tle() {
        int[] arr = new int[30];
        Arrays.fill(arr, 1);
        assertThat(numberOfArithmeticSlices(arr)).isEqualTo(1073741358);
    }

    public int numberOfArithmeticSlices(int[] nums) {
        Map<Integer, Map<Long, Integer>> dp = IntStream
                .range(0, nums.length)
                .boxed()
                .collect(Collectors.toMap(Integer::valueOf, HashMap::new));

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                long diff = (long) nums[j] - nums[i];
                int cnt = dp.get(i).getOrDefault(diff, 0);
                dp.get(j).merge(diff, cnt + 1, Integer::sum);
                sum += cnt;
            }
        }
        return sum;
    }
}
