package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 52ms
 * Beats66.00%
 */
public class Q2537CountTheNumberOfGoodSubarrays2 {

    @Test
    public void test() {
        assertThat(countGood(new int[]{1, 1, 1, 1, 1}, 10)).isEqualTo(1);
        assertThat(countGood(new int[]{3, 1, 4, 3, 2, 2, 4}, 2)).isEqualTo(4);
    }

    @Test
    public void tle() {
        int[] arr = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        assertThat(countGood(arr, 100)).isEqualTo(0);
    }

    public long countGood(int[] nums, int k) {
        Map<Integer, Integer> cnts = new HashMap<>();
        int right = 0;
        long answer = 0;
        int currentGoodSubarrayCnt = 0;
        for (int left : nums) {
            boolean canMake = false;
            while (right <= nums.length) {
                canMake = currentGoodSubarrayCnt >= k;
                if (canMake) {
                    answer += nums.length - right + 1;
                    break;
                }
                if (right == nums.length)
                    break;
                int newValue = cnts.merge(nums[right++], 1, Integer::sum);
                currentGoodSubarrayCnt += newValue * (newValue - 1) / 2 - (newValue - 1) * (newValue - 2) / 2;
            }
            int newValue = cnts.merge(left, -1, Integer::sum);
            currentGoodSubarrayCnt += newValue * (newValue - 1) / 2 - (newValue + 1) * (newValue) / 2;
            if (!canMake)
                break;
        }
        return answer;
    }

}
