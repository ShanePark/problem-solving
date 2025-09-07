package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 0
 * ms
 * Beats
 * 100.00%
 */
public class Q1304FindNUniqueIntegersSumUpToZero2 {

    @Test
    public void test() {
        for (int i = 1; i <= 5; i++) {
            assertThat(Arrays.stream(sumZero(i)).sum()).isEqualTo(0);
            assertThat(Arrays.stream(sumZero(i)).distinct()).hasSize(i);
        }
    }

    public int[] sumZero(int n) {
        int[] answer = new int[n];
        for (int i = 0; i < n / 2; i++) {
            answer[i] = i + 1;
            answer[n - 1 - i] = -i - 1;
        }
        return answer;
    }

}
