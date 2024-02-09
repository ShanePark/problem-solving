package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * not mine
 */
public class Q368LargestDivisibleSubset {

    @Test
    public void test() {
        assertThat(largestDivisibleSubset(new int[]{1, 2, 3})).containsExactlyInAnyOrder(1, 2);
        assertThat(largestDivisibleSubset(new int[]{1, 2, 4, 8})).containsExactlyInAnyOrder(1, 2, 4, 8);
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        final int LENGTH = nums.length;
        int[] lengths = new int[LENGTH];
        int[] prev = new int[LENGTH];

        Arrays.sort(nums);

        int max = 0;
        int index = -1;
        for (int i = 0; i < LENGTH; i++) {
            lengths[i] = 1;
            prev[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0 && lengths[j] + 1 > lengths[i]) {
                    lengths[i] = lengths[j] + 1;
                    prev[i] = j;
                }
            }
            if (lengths[i] > max) {
                max = lengths[i];
                index = i;
            }
        }
        List<Integer> res = new ArrayList<>();
        while (index != -1) {
            res.add(nums[index]);
            index = prev[index];
        }
        return res;
    }

}
