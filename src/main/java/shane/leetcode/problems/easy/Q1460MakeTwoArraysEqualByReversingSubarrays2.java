package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime3msBeats85.96%
 */
public class Q1460MakeTwoArraysEqualByReversingSubarrays2 {

    @Test
    public void test() {
        assertThat(canBeEqual(new int[]{1, 2, 3, 4}, new int[]{2, 4, 1, 3})).isTrue();
        assertThat(canBeEqual(new int[]{7}, new int[]{7})).isTrue();
        assertThat(canBeEqual(new int[]{3, 7, 9}, new int[]{3, 7, 11})).isFalse();
    }

    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != target[i]) {
                return false;
            }
        }
        return true;
    }

}
