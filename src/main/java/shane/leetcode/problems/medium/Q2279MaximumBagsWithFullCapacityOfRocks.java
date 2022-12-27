package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 15 ms Beats 94.69%
 * Memory 52.6 MB Beats 86.73%
 */
public class Q2279MaximumBagsWithFullCapacityOfRocks {

    @Test
    public void test() {
        assertThat(maximumBags(new int[]{2, 3, 4, 5}, new int[]{1, 2, 4, 4}, 2))
                .isEqualTo(3);
        assertThat(maximumBags(new int[]{10, 2, 2}, new int[]{2, 2, 0}, 100))
                .isEqualTo(3);

    }

    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        for (int i = 0; i < capacity.length; i++) {
            capacity[i] -= rocks[i];
        }
        Arrays.sort(capacity);
        for (int i = 0; i < capacity.length; i++) {
            if (additionalRocks < capacity[i])
                return i;
            additionalRocks -= capacity[i];
        }
        return capacity.length;
    }

}
