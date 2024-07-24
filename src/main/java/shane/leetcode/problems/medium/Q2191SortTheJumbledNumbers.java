package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime162msBeats65.69%
 */
public class Q2191SortTheJumbledNumbers {

    @Test
    public void test() {
        assertThat(sortJumbled(new int[]{8, 9, 4, 0, 2, 1, 3, 5, 7, 6}, new int[]{991, 338, 38}))
                .containsExactly(338, 38, 991);
        assertThat(sortJumbled(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, new int[]{789, 456, 123}))
                .containsExactly(123, 456, 789);
    }

    public int[] sortJumbled(int[] mapping, int[] nums) {
        List<Number> numbers = new ArrayList<>();
        for (int num : nums) {
            numbers.add(new Number(num, mapping));
        }
        return numbers.stream()
                .sorted(Comparator.comparingInt(n -> n.value))
                .mapToInt(n -> n.original)
                .toArray();
    }

    static class Number {
        final int original;
        final int value;

        @Override
        public String toString() {
            return "Number{" +
                    "original=" + original +
                    ", value=" + value +
                    '}';
        }

        public Number(int num, int[] mapping) {
            this.original = num;
            StringBuilder sb = new StringBuilder(String.valueOf(num));
            for (int i = 0; i < sb.length(); i++) {
                char before = sb.charAt(i);
                sb.setCharAt(i, (char) (mapping[before - '0'] + '0'));
            }
            this.value = Integer.parseInt(sb.toString());
        }
    }

}
