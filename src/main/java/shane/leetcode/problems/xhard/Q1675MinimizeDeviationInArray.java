package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 67 / 75 testcases passed
 */
public class Q1675MinimizeDeviationInArray {

    @Test
    public void test() {
        assertThat(minimumDeviation(new int[]{4, 9, 4, 5})).isEqualTo(5);
        assertThat(minimumDeviation(new int[]{1, 2, 3, 4})).isEqualTo(1);
        assertThat(minimumDeviation(new int[]{4, 1, 5, 20, 3})).isEqualTo(3);
        assertThat(minimumDeviation(new int[]{2, 10, 8})).isEqualTo(3);
    }

    @Test
    public void failTest() {
        assertThat(minimumDeviation(new int[]{399, 908, 648, 357, 693, 502, 331, 649, 596, 698}))
                .isEqualTo(315);
    }

    public int minimumDeviation(int[] nums) {
        TreeSet<Integer> tree = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            tree.add(nums[i]);
        }

        int diff = tree.last() - tree.first();
        while (true) {
            Integer min = tree.first();
            Integer max = tree.last();
            tree.remove(min);
            tree.remove(max);
            if (min % 2 == 1) {
                min *= 2;
            }
            if (max % 2 == 0) {
                max /= 2;
            }
            tree.add(min);
            tree.add(max);
            int newDiff = tree.last() - tree.first();
            if (diff <= newDiff)
                break;
            diff = newDiff;
        }
        return diff;
    }

}
