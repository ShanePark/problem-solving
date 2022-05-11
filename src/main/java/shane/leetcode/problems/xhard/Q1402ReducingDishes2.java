package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1402ReducingDishes2 {

    @Test
    public void test() {
        assertThat(maxSatisfaction(new int[]{-1, -8, 0, 5, -9})).isEqualTo(14);
        assertThat(maxSatisfaction(new int[]{4, 3, 2})).isEqualTo(20);
        assertThat(maxSatisfaction(new int[]{-1, -4, -5})).isEqualTo(0);
    }

    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int sum = 0;
        int answer = 0;
        for (int i = satisfaction.length - 1; i >= 0; i--) {
            if (satisfaction[i] <= -sum)
                return answer;
            sum += satisfaction[i];
            answer += sum;
        }
        return answer;
    }
}
