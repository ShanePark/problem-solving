package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 22
 * ms
 * Beats
 * 23.88%
 */
public class Q2560HouseRobberIV2 {

    @Test
    public void test() {
        assertThat(minCapability(new int[]{2, 3, 5, 9}, 2)).isEqualTo(5);
        assertThat(minCapability(new int[]{2, 7, 9, 3, 1}, 2)).isEqualTo(2);
    }

    @Test
    public void fail() {
        assertThat(minCapability(new int[]{9, 6, 20, 21, 8}, 3)).isEqualTo(20);
    }

    public int minCapability(int[] nums, int k) {
        int left = 1;
        int right = (int) 1e9;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (possible(nums, k, mid)) {
                right = mid;
                continue;
            }
            left = mid + 1;
        }
        return left;
    }

    private boolean possible(int[] nums, int k, int capability) {
        boolean lastVisit = false;
        for (int num : nums) {
            if (lastVisit) {
                lastVisit = false;
                continue;
            }
            if (num <= capability) {
                lastVisit = true;
                if (--k == 0)
                    return true;
            }
        }
        return false;
    }


}
