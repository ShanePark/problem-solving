package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 35ms Beats 7.23%of users with Java
 * Memory Details 54.72MB Beats 58.20%of users with Java
 */
public class Q1561MaximumNumberOfCoinsYouCanGet2 {

    @Test
    public void test() {
        assertThat(maxCoins(new int[]{9, 8, 7, 6, 5, 1, 2, 3, 4})).isEqualTo(18);
        assertThat(maxCoins(new int[]{2, 4, 1, 2, 7, 8})).isEqualTo(9);
        assertThat(maxCoins(new int[]{2, 4, 5})).isEqualTo(4);
    }

    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        Deque<Integer> deque = new ArrayDeque<>();
        for (int pile : piles) {
            deque.offerLast(pile);
        }
        int sum = 0;
        while (!deque.isEmpty()) {
            deque.pollFirst();
            deque.pollLast();
            sum += deque.pollLast();
        }
        return sum;
    }

}
