package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 9 ms
 */
public class Q2799CountCompleteSubarraysInAnArray3 {

    @Test
    public void test() {
        assertThat(countCompleteSubarrays(new int[]{1, 3, 1, 2, 2})).isEqualTo(4);
        assertThat(countCompleteSubarrays(new int[]{5, 5, 5, 5})).isEqualTo(10);
    }

    public int countCompleteSubarrays(int[] nums) {
        int completeCnt = getCompleteCnt(nums);
        Map<Integer, Integer> cntMap = new HashMap<>();
        int left = 0;
        int answer = 0;
        for (int num : nums) {
            cntMap.merge(num, 1, Integer::sum);
            while (cntMap.size() == completeCnt) {
                int newVal = cntMap.merge(nums[left++], -1, Integer::sum);
                if (newVal == 0)
                    cntMap.remove(nums[left - 1]);
            }
            answer += left;
        }
        return answer;
    }

    private static int getCompleteCnt(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set.size();
    }

}
