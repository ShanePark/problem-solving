package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 37ms
 * Beats39.10%
 */
public class Q2780MinimumIndexOfAValidSplit {

    @Test
    public void test() {
        assertThat(minimumIndex(List.of(1, 2, 2, 2))).isEqualTo(2);
        assertThat(minimumIndex(List.of(2, 1, 3, 1, 1, 1, 7, 1, 2, 1))).isEqualTo(4);
        assertThat(minimumIndex(List.of(3, 3, 3, 3, 7, 2, 2))).isEqualTo(-1);
    }

    public int minimumIndex(List<Integer> nums) {
        int dominant = findDominant(nums);
        int[] cnt = new int[nums.size()];
        cnt[0] = nums.get(0) == dominant ? 1 : 0;
        for (int i = 1; i < cnt.length; i++) {
            cnt[i] = cnt[i - 1] + (nums.get(i) == dominant ? 1 : 0);
        }
        for (int i = 0; i < cnt.length; i++) {
            int leftLength = i + 1;
            int leftDominant = cnt[i];
            if (leftDominant <= leftLength / 2) {
                continue;
            }

            int rightLength = cnt.length - i - 1;
            int rightDominant = cnt[cnt.length - 1] - cnt[i];
            if (rightLength / 2 < rightDominant)
                return i;
        }
        return -1;
    }

    private int findDominant(List<Integer> nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (Integer num : nums) {
            cnt.merge(num, 1, Integer::sum);
        }
        return cnt.entrySet().stream()
                .min((e1, e2) -> e2.getValue() - e1.getValue())
                .get()
                .getKey();
    }

}
