package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 2 ms Beats 81.19%
 * Memory 40.7 MB Beats 94.45%
 */
public class Q1502CanMakeArithmeticProgressionFromSequence {

    @Test
    void tset() {
        assertThat(canMakeArithmeticProgression(new int[]{3, 5, 1})).isTrue();
        assertThat(canMakeArithmeticProgression(new int[]{1, 2, 4})).isFalse();
    }

    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] != diff)
                return false;
        }
        return true;
    }

}
