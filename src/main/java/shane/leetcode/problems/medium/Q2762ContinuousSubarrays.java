package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.TreeMap;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime43msBeats31.31%
 */
public class Q2762ContinuousSubarrays {

    @Test
    public void test() {
        assertThat(continuousSubarrays(new int[]{42, 41, 42, 41, 41, 40, 39, 38})).isEqualTo(28);
        assertThat(continuousSubarrays(new int[]{5, 4, 2, 4})).isEqualTo(8);
        assertThat(continuousSubarrays(new int[]{1, 2, 3})).isEqualTo(6);
    }

    public long continuousSubarrays(int[] nums) {
        long sum = 0;
        TreeMap<Integer, Integer> cntMap = new TreeMap<>();
        int right = 0;
        for (int left = 0; left < nums.length; left++) {
            while (right < nums.length) {
                int num = nums[right];
                cntMap.merge(num, 1, Integer::sum);
                if (cntMap.lastKey() - cntMap.firstKey() > 2) {
                    cntMap.remove(num);
                    break;
                }
                right++;
            }
            int num = nums[left];
            cntMap.merge(num, -1, Integer::sum);
            if (cntMap.get(num) == 0)
                cntMap.remove(num);
            int len = right - left;
            sum += len;
        }
        return sum;
    }

}
