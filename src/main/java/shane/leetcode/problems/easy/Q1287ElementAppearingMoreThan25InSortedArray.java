package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 0ms Beats 100.00%of users with Java
 * Memory Details 43.23MB Beats 64.85%of users with Java
 */
public class Q1287ElementAppearingMoreThan25InSortedArray {

    @Test
    public void test() {
        assertThat(findSpecialInteger(new int[]{1, 2, 2, 6, 6, 6, 7, 10})).isEqualTo(6);
        assertThat(findSpecialInteger(new int[]{1, 1})).isEqualTo(1);
        assertThat(findSpecialInteger(new int[]{1})).isEqualTo(1);
    }

    public int findSpecialInteger(int[] arr) {
        int length = arr.length;
        int before = -1;
        int cnt = 0;
        for (int n : arr) {
            if (n == before) {
                cnt++;
            } else {
                cnt = 1;
                before = n;
            }
            if (cnt * 4 > length) {
                return n;
            }
        }
        return -1;
    }

}
