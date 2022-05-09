package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1460MakeTwoArraysEqualByReversingSubarrays {

    @Test
    public void test() {
        assertThat(canBeEqual(new int[]{1, 2, 3, 4}, new int[]{2, 4, 1, 3})).isTrue();
        assertThat(canBeEqual(new int[]{7}, new int[]{7})).isTrue();
        assertThat(canBeEqual(new int[]{3, 7, 9}, new int[]{3, 7, 11})).isFalse();
    }

    public boolean canBeEqual(int[] target, int[] arr) {
        int[] bucket = new int[1001];
        for (int i = 0; i < target.length; i++) {
            bucket[target[i]]++;
            bucket[arr[i]]--;
        }
        for (int i = 1; i <= 1000; i++) {
            if (bucket[i] != 0)
                return false;
        }
        return true;
    }
}
