package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 2ms
 * Beats95.83%
 */
public class Q2657FindThePrefixCommonArrayOfTwoArrays2 {

    @Test
    public void test() {
        assertThat(findThePrefixCommonArray(new int[]{1, 3, 2, 4}, new int[]{3, 1, 2, 4})).containsExactly(0, 2, 3, 4);
        assertThat(findThePrefixCommonArray(new int[]{2, 3, 1}, new int[]{3, 1, 2})).containsExactly(0, 1, 3);
    }

    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] cnt = new int[A.length];
        int[] answer = new int[A.length];

        int cur = 0;
        for (int i = 0; i < A.length; i++) {
            if (++cnt[A[i] - 1] == 0)
                cur++;
            if (--cnt[B[i] - 1] == 0)
                cur++;
            answer[i] = cur;
        }
        return answer;
    }

}
