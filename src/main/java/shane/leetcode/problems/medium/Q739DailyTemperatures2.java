package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 77 ms Beats 35.43% of users with Java
 */
public class Q739DailyTemperatures2 {

    @Test
    public void test() {
        assertThat(dailyTemperatures(new int[]{34, 80, 80, 34, 34, 80, 80, 80, 80, 34})).isEqualTo(new int[]{1, 0, 0, 2, 1, 0, 0, 0, 0, 0});
        assertThat(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})).isEqualTo(new int[]{1, 1, 4, 2, 1, 1, 0, 0});
        assertThat(dailyTemperatures(new int[]{30, 40, 50, 60})).isEqualTo(new int[]{1, 1, 1, 0});
        assertThat(dailyTemperatures(new int[]{30, 60, 90})).isEqualTo(new int[]{1, 1, 0});
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Stack<Data> stack = new Stack<>();
        int max = 0;
        for (int i = temperatures.length - 1; i >= 0; i--) {
            int temperature = temperatures[i];
            if (stack.isEmpty() || max <= temperature) {
                max = temperature;
                answer[i] = 0;
                stack.push(new Data(temperature));
                continue;
            }

            int day = 0;
            while (!stack.isEmpty()) {
                Data pop = stack.pop();
                day += pop.day;
                if (temperature < pop.temp) {
                    stack.push(pop);
                    break;
                }
            }
            answer[i] = day;
            stack.peek().day = day;
            stack.push(new Data(temperature));
        }
        return answer;
    }

    static class Data {
        final int temp;
        int day;

        public Data(int temp) {
            this.temp = temp;
            this.day = 1;
        }
    }

}
