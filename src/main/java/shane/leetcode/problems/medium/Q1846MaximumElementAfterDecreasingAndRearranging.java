package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 16ms Beats 7.14%of users with Java
 * Memory Details 56.13MB Beats 72.86%of users with Java
 */
public class Q1846MaximumElementAfterDecreasingAndRearranging {

    @Test
    public void test() {
        assertThat(maximumElementAfterDecrementingAndRearranging(new int[]{100, 1, 1000})).isEqualTo(3);
        assertThat(maximumElementAfterDecrementingAndRearranging(new int[]{2, 3, 4, 5})).isEqualTo(4);
        assertThat(maximumElementAfterDecrementingAndRearranging(new int[]{2, 2, 1, 2, 1})).isEqualTo(2);
        assertThat(maximumElementAfterDecrementingAndRearranging(new int[]{1, 2, 3, 4, 5})).isEqualTo(5);
    }

    @Test
    public void test2() {
        assertThat(maximumElementAfterDecrementingAndRearranging(new int[]{2, 2, 2, 2, 5})).isEqualTo(3);
    }

    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i : arr) {
            deque.addLast(i);
        }
        int cur = 0;
        while (!deque.isEmpty()) {
            int first = deque.pollFirst();
            if (cur == first || cur + 1 == first) {
                cur = first;
                continue;
            }
            cur++;
        }
        return cur;
    }

}
