package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 2 ms, faster than 75.25% of Java online submissions for Fizz Buzz.
 * Memory Usage: 48.5 MB, less than 33.22% of Java online submissions for Fizz Buzz.
 */
public class Q412FizzBuzz {

    @Test
    public void test() {
        assertThat(fizzBuzz(3)).containsExactly("1", "2", "Fizz");
        assertThat(fizzBuzz(5)).containsExactly("1", "2", "Fizz", "4", "Buzz");
        assertThat(fizzBuzz(15)).containsExactly("1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz");
    }

    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                list.add("FizzBuzz");
            } else if (i % 3 == 0) {
                list.add("Fizz");
            } else if (i % 5 == 0) {
                list.add("Buzz");
            } else {
                list.add(String.valueOf(i));
            }
        }
        return list;
    }
}
