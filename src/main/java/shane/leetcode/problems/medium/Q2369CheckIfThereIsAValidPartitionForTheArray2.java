package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 371ms Beats 5.83%of users with Java
 * Memory Details 122.75mb Beats 5.83%of users with Java
 */
@SuppressWarnings("ALL")
public class Q2369CheckIfThereIsAValidPartitionForTheArray2 {

    @Test
    public void test() {
        assertThat(validPartition(new int[]{4, 4, 4, 5, 6})).isTrue();
        assertThat(validPartition(new int[]{1, 1, 1, 2})).isFalse();
    }

    public boolean validPartition(int[] nums) {
        final int LENGTH = nums.length;
        Map<String, Boolean> dp = new HashMap<>();
        return validPartition(dp, nums, 0, LENGTH - 1);
    }

    private boolean validPartition(Map<String, Boolean> dp, int[] nums, int from, int end) {
        if (dp.get(from + " " + end) != null)
            return dp.get(from + " " + end);
        if (from + 1 == end) {
            dp.put(from + " " + end, nums[from] == nums[end]);
            return dp.get(from + " " + end);
        }
        if (from + 2 == end) {
            if (nums[from] == nums[from + 1] && nums[from] == nums[from + 2]) {
                dp.put(from + " " + end, true);
                return true;
            }
            if (nums[from + 2] == nums[from] + 2 && nums[from + 1] == nums[from] + 1) {
                dp.put(from + " " + end, true);
                return true;

            }
            dp.put(from + " " + end, false);
            return false;
        }
        if (from + 3 == end) {
            dp.put(from + " " + end, validPartition(dp, nums, from, from + 1) && validPartition(dp, nums, from + 2, end));
            return dp.get(from + " " + end);
        }

        // cut length2
        if (validPartition(dp, nums, from, from + 1) == true && validPartition(dp, nums, from + 2, end) == true) {
            dp.put(from + " " + end, true);
            return true;
        }

        // cut length3
        if (validPartition(dp, nums, from, from + 2) == true && validPartition(dp, nums, from + 3, end) == true) {
            dp.put(from + " " + end, true);
            return true;
        }
        dp.put(from + " " + end, false);
        return false;
    }

}
