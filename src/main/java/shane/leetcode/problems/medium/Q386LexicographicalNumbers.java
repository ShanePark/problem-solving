package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime2msBeats72.07%
 */
public class Q386LexicographicalNumbers {

    @Test
    public void test() {
        assertThat(lexicalOrder(13)).containsExactly(1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9);
        assertThat(lexicalOrder(2)).containsExactly(1, 2);
    }

    public List<Integer> lexicalOrder(int n) {
        List<Integer> answer = new ArrayList<>();
        add(n, 0, answer);
        return answer;
    }

    private void add(int max, int prefix, List<Integer> answer) {
        for (int i = 0; i <= 9; i++) {
            int n = prefix * 10 + i;
            if (n == 0)
                continue;
            if (n <= max) {
                answer.add(n);
                add(max, n, answer);
            }
        }
    }

}
