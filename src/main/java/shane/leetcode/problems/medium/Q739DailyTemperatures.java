package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 213 ms Beats 27.85%
 * Memory 137 MB Beats 30.23%
 */
public class Q739DailyTemperatures {

    @Test
    public void test() {
        assertThat(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})).isEqualTo(new int[]{1, 1, 4, 2, 1, 1, 0, 0});
        assertThat(dailyTemperatures(new int[]{30, 40, 50, 60})).isEqualTo(new int[]{1, 1, 1, 0});
        assertThat(dailyTemperatures(new int[]{30, 60, 90})).isEqualTo(new int[]{1, 1, 0});
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        Stack<Temperature> stack = new Stack<>();
        for (int i = length - 1; i >= 0; i--) {
            Temperature current = new Temperature(temperatures[i]);
            temperatures[i] = current.distanceToNextWarmerDay(stack);
            stack.push(current);
        }
        return temperatures;
    }

    class Temperature {
        int temp;
        int warmLength = 1;

        public Temperature(int temp) {
            this.temp = temp;
        }

        private boolean isWarmerThanNext(Stack<Temperature> stack) {
            if (stack.isEmpty())
                return false;
            return stack.peek().temp <= this.temp;
        }

        public int distanceToNextWarmerDay(Stack<Temperature> stack) {
            int cnt = 1;
            while (isWarmerThanNext(stack)) {
                Temperature pop = stack.pop();
                cnt += pop.warmLength - 1;
            }
            int distanceToNext = stack.isEmpty() ? 0 : cnt;
            this.warmLength = distanceToNext + 1;
            return distanceToNext;
        }
    }

}
