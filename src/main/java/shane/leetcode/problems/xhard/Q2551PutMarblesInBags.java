package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2551PutMarblesInBags {

    @Test
    void test() {
        assertThat(putMarbles(new int[]{1, 3, 5, 1}, 2)).isEqualTo(4);
        assertThat(putMarbles(new int[]{1, 3}, 2)).isEqualTo(0);
    }

    public long putMarbles(int[] weights, int k) {
        int[] pair = new int[weights.length - 1];
        for (int i = 0; i < pair.length; i++) {
            pair[i] = weights[i] + weights[i + 1];
        }
        Arrays.sort(pair);

        long answer = 0;
        for (int i = 0; i + 1 < k; i++) {
            answer += pair[weights.length - 2 - i] - pair[i];
        }

        return answer;
    }
}
