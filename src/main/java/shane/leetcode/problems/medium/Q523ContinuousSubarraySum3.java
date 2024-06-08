package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class Q523ContinuousSubarraySum3 {

    @Test
    public void test() {
        assertThat(checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6)).isTrue();
        assertThat(checkSubarraySum(new int[]{1, 0, 1, 0, 1}, 4)).isFalse();
        assertThat(checkSubarraySum(new int[]{5, 0, 0, 0}, 3)).isTrue();
        assertThat(checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 6)).isTrue();
        assertThat(checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 13)).isFalse();
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int memo = 0;
        for (int num : nums) {
            int target = (memo + num) % k;
            if (set.contains(target))
                return true;
            set.add(memo);
            memo = target;
        }
        return false;
    }

}
