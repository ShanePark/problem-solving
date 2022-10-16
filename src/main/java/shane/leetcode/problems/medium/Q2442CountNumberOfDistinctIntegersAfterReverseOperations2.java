package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 129 ms, faster than 33.33% of Java online submissions for Count Number of Distinct Integers After Reverse Operations.
 * Memory Usage: 126.6 MB, less than 16.67% of Java online submissions for Count Number of Distinct Integers After Reverse Operations.
 */
public class Q2442CountNumberOfDistinctIntegersAfterReverseOperations2 {

    @Test
    public void test() {
        assertThat(countDistinctIntegers(new int[]{1, 13, 10, 12, 31})).isEqualTo(6);
        assertThat(countDistinctIntegers(new int[]{2, 2, 2})).isEqualTo(1);
    }

    public int countDistinctIntegers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
            int reversed = 0;
            while (num > 0) {
                reversed = (reversed * 10) + (num % 10);
                num /= 10;
            }
            set.add(reversed);
        }
        return set.size();
    }
}
