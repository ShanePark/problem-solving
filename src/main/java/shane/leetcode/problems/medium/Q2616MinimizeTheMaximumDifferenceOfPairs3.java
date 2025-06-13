package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2616MinimizeTheMaximumDifferenceOfPairs3 {

    @Test
    public void test() {
        assertThat(minimizeMax(new int[]{10, 1, 2, 7, 1, 3}, 2)).isEqualTo(1);
        assertThat(minimizeMax(new int[]{4, 2, 1, 2}, 1)).isEqualTo(0);
        assertThat(minimizeMax(new int[]{0, 5, 3, 4}, 0)).isEqualTo(0);
    }

    public int minimizeMax(int[] nums, int p) {
        if (p == 0)
            return 0;
        Arrays.sort(nums);
        int left = 0;
        int right = (int) 1e9;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (possible(nums, mid, p)) {
                right = mid;
                continue;
            }
            left = mid + 1;
        }
        return left;
    }

    private boolean possible(int[] nums, int mid, int p) {
        Integer before = null;
        for (int num : nums) {
            if (before == null) {
                before = num;
                continue;
            }
            if (num - before <= mid) {
                if (--p == 0)
                    return true;
                before = null;
                continue;
            }
            before = num;
        }
        return false;
    }

}
