package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 17ms Beats 16.67%of users with Java
 * Memory Details 57.78MB Beats 10.87%of users with Java
 */
public class Q1535FindTheWinnerOfAnArrayGame {

    @Test
    public void test() {
        assertThat(getWinner(new int[]{2, 1, 3, 5, 4, 6, 7}, 2)).isEqualTo(5);
        assertThat(getWinner(new int[]{3, 2, 1}, 10)).isEqualTo(3);
    }

    @Test
    public void edge() {
        assertThat(getWinner(new int[]{1, 25, 35, 42, 68, 70}, 1)).isEqualTo(25);
    }

    @Test
    public void tle() {
        assertThat(getWinner(new int[]{1, 11, 22, 33, 44, 55, 66, 77, 88, 99}, 1000000000)).isEqualTo(99);
    }

    public int getWinner(int[] arr, int k) {
        if (arr.length <= k)
            return Arrays.stream(arr).max().getAsInt();

        Deque<Integer> deque = new LinkedList<>();
        for (int i : arr) {
            deque.offerLast(i);
        }
        int wins = 0;
        while (wins < k) {
            int first = deque.pollFirst();
            int second = deque.pollFirst();
            int bigger = Math.max(first, second);
            int smaller = Math.min(first, second);
            if (first < second) {
                wins = 0;
            }
            wins++;
            if (wins == k)
                return bigger;
            deque.offerLast(smaller);
            deque.offerFirst(bigger);
        }
        return -1;
    }

}
