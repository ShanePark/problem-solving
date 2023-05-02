package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 0 ms Beats 100%
 * Memory 42.1 MB Beats 65.10%
 */
public class Q1822SignOfTheProductOfAnArray {

    @Test
    public void test() {
        assertThat(arraySign(new int[]{-1, -2, -3, -4, 3, 2, 1})).isEqualTo(1);
        assertThat(arraySign(new int[]{1, 5, 0, 2, -3})).isEqualTo(0);
        assertThat(arraySign(new int[]{-1, 1, -1, 1, -1})).isEqualTo(-1);
    }

    public int arraySign(int[] nums) {
        int cnt = 0;
        for (int num : nums) {
            if (num == 0)
                return 0;
            if (num < 0)
                cnt++;
        }
        return cnt % 2 == 0 ? 1 : -1;
    }

}
