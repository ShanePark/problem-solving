package shane.programmers.lv3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class 연속_펄스_부분_수열의_합 {


    @Test
    public void test() {
        assertThat(solution(new int[]{2, 3, -6, 1, 3, -1, 2, 4})).isEqualTo(10);
    }

    public long solution(int[] sequence) {
        for (int i = 0; i < sequence.length; i++) {
            if (i % 2 == 0)
                sequence[i] *= -1;
        }
        long max = 0;
        long sum = 0;
        long min = 0;
        long minSum = 0;
        for (int i = 0; i < sequence.length; i++) {
            sum += sequence[i];
            minSum += sequence[i];

            max = Math.max(max, sum);
            min = Math.min(min, minSum);

            sum = Math.max(0, sum);
            minSum = Math.min(0, minSum);
        }
        return Math.max(max, -min);
    }

}
