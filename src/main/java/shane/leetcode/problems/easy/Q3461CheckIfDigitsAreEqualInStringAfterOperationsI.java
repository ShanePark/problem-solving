package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 8ms
 * Beats72.03%
 */
public class Q3461CheckIfDigitsAreEqualInStringAfterOperationsI {

    @Test
    public void test() {
        assertThat(hasSameDigits("3902")).isTrue();
        assertThat(hasSameDigits("34789")).isFalse();
    }

    public boolean hasSameDigits(String s) {
        List<Integer> list = new ArrayList<>();
        for (char c : s.toCharArray()) {
            list.add(c - '0');
        }
        while (list.size() > 2) {
            List<Integer> next = new ArrayList<>();
            for (int i = 1; i < list.size(); i++) {
                next.add((list.get(i - 1) + list.get(i)) % 10);
            }
            list = next;
        }
        return list.get(0) == (int) list.get(1);
    }

}
