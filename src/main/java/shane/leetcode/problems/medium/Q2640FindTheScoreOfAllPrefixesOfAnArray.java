package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 2 ms Beats 100.00% of users with Java
 */
public class Q2640FindTheScoreOfAllPrefixesOfAnArray {

    @Test
    public void test() {
        assertThat(findPrefixScore(new int[]{2, 3, 7, 5, 10})).containsExactly(4, 10, 24, 36, 56);
        assertThat(findPrefixScore(new int[]{1, 1, 2, 4, 8, 16})).containsExactly(2, 4, 8, 16, 32, 64);
    }

    public long[] findPrefixScore(int[] nums) {
        int LENGTH = nums.length;
        int[] conv = new int[LENGTH];
        int max = 0;
        for (int i = 0; i < LENGTH; i++) {
            int num = nums[i];
            max = Math.max(num, max);
            conv[i] = max + num;
        }
        long[] answer = new long[LENGTH];
        long cur = 0;
        for (int i = 0; i < LENGTH; i++) {
            cur += conv[i];
            answer[i] = cur;
        }
        return answer;
    }

}
