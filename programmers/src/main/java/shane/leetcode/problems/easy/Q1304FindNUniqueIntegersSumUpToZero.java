package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1304FindNUniqueIntegersSumUpToZero {

    @Test
    public void test() {
        assertThat(Arrays.stream(sumZero(5)).sum()).isEqualTo(0);
        assertThat(Arrays.stream(sumZero(3)).sum()).isEqualTo(0);
        assertThat(Arrays.stream(sumZero(4)).sum()).isEqualTo(0);
        assertThat(Arrays.stream(sumZero(1)).sum()).isEqualTo(0);
    }

    public int[] sumZero(int n) {
        int[] answer = new int[n];
        for (int i = 0; i < n / 2; i++) {
            answer[i] = i + 1;
            answer[n - 1 - i] = -(i + 1);
        }
        return answer;
    }
}
