package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 24
 * ms
 * Beats
 * 6.86%
 */
public class Q386LexicographicalNumbers2 {

    @Test
    public void test() {
        assertThat(lexicalOrder(13)).containsExactly(1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9);
        assertThat(lexicalOrder(2)).containsExactly(1, 2);
    }

    public List<Integer> lexicalOrder(int n) {
        return IntStream.range(1, n + 1)
                .mapToObj(String::valueOf)
                .sorted()
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

}
