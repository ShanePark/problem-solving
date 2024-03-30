package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class Q992SubarraysWithKDifferentIntegers {

    @Test
    public void test() {
        assertThat(subarraysWithKDistinct(new int[]{1, 2, 1, 2, 3}, 2)).isEqualTo(7);
        assertThat(subarraysWithKDistinct(new int[]{1, 2, 1, 3, 4}, 3)).isEqualTo(3);
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);

    }

    int atMostK(int[] nums, int k) {
        int left = 0;
        int answer = 0;
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int right = 0; right < nums.length; right++) {
            if (!cntMap.containsKey(nums[right])) {
                k--;
            }
            cntMap.merge(nums[right], 1, Integer::sum);
            while (k < 0) {
                if (cntMap.merge(nums[left], -1, Integer::sum) == 0) {
                    cntMap.remove(nums[left]);
                    k++;
                }
                left++;
            }
            answer += (right - left + 1);
        }
        return answer;
    }

}
