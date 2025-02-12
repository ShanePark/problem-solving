package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
113ms
Beats12.30%
 */
public class Q2342MaxSumOfAPairWithEqualSumOfDigits {

    @Test
    public void test() {
        assertThat(maximumSum(new int[]{18, 43, 36, 13, 7})).isEqualTo(54);
        assertThat(maximumSum(new int[]{10, 12, 19, 14})).isEqualTo(-1);
    }

    public int maximumSum(int[] nums) {
        Map<Integer, List<Integer>> digitSums = new HashMap<>();
        for (int num : nums) {
            int digitSum = 0;
            int tmp = num;
            while (tmp > 0) {
                digitSum += tmp % 10;
                tmp /= 10;
            }
            digitSums.computeIfAbsent(digitSum, v -> new ArrayList<>()).add(num);
        }
        return digitSums.values().stream()
                .filter(integers -> integers.size() > 1)
                .mapToInt(integers -> integers.stream().sorted(Comparator.reverseOrder()).limit(2).mapToInt(Integer::valueOf).sum())
                .max().orElse(-1);
    }

}
