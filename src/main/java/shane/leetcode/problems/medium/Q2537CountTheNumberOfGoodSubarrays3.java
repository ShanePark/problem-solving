package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2537CountTheNumberOfGoodSubarrays3 {

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
        int sameCnt = 0;
        for (int left : nums) {
            while (sameCnt < k && right < nums.length) {
                sameCnt += cnts.merge(nums[right++], 1, Integer::sum) - 1;
            }
            if (sameCnt < k)
                break;
            answer += nums.length - right + 1;
            sameCnt -= cnts.merge(left, -1, Integer::sum);
        }
        return answer;
    }

}
