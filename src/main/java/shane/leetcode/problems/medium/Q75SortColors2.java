package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 0
 * ms
 * Beats
 * 100.00%
 */
public class Q75SortColors2 {

    @Test
    public void test() {
        int[] arr = {2, 0, 2, 1, 1, 0};
        sortColors(arr);
        assertThat(arr).containsExactly(0, 0, 1, 1, 2, 2);
    }

    @Test
    public void test2() {
        int[] arr = new int[]{2, 0, 1};
        sortColors(arr);
        assertThat(arr).containsExactly(0, 1, 2);
    }

    @Test
    public void test3() {
        int[] arr = new int[]{0, 0, 1};
        sortColors(arr);
        assertThat(arr).containsExactly(0, 0, 1);
    }

    public void sortColors(int[] nums) {
        int[] cnt = new int[3];
        for (int num : nums) {
            cnt[num]++;
        }
        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < cnt[i]; j++) {
                nums[index++] = i;
            }
        }
    }

}
