package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 0 ms Beats 100.00% of users with Java
 */
public class Q1291SequentialDigits3 {

    @Test
    public void test() {
        assertThat(sequentialDigits(100, 300)).isEqualTo(List.of(123, 234));
        assertThat(sequentialDigits(1000, 13000)).isEqualTo(List.of(1234, 2345, 3456, 4567, 5678, 6789, 12345));
        assertThat(sequentialDigits(10, (int) 1e9)).hasSize(36);
        assertThat(sequentialDigits(10, 10)).isEmpty();
    }

    public static List<Integer> sequentialDigits(int low, int high) {
        List<Integer> answer = new ArrayList<>();
        int cur = 12;
        while (cur < low) {
            cur = getNextSequentialDigit(cur);
        }

        while (cur <= high) {
            answer.add(cur);
            cur = getNextSequentialDigit(cur);
        }
        return answer;
    }

    private static int getNextSequentialDigit(int num) {
        int length = (int) Math.log10(num) + 1;
        if (num % 10 == 9) {
            int sum = 0;
            for (int i = 1; i <= length + 1; i++) {
                sum += i * (int) Math.pow(10, length - i + 1);
            }
            return sum;
        }
        for (int i = 0; i < length; i++) {
            num += (int) Math.pow(10, i);
        }
        return num;
    }

}
