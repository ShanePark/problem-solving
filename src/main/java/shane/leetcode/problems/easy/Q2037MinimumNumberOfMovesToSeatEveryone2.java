package shane.leetcode.problems.easy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * Runtime 3 ms Beats 62.42% of users with Java
 */
public class Q2037MinimumNumberOfMovesToSeatEveryone2 {

    @Test
    void test() {
        Assertions.assertThat(minMovesToSeat(new int[]{3, 1, 5}, new int[]{2, 7, 4})).isEqualTo(4);
        Assertions.assertThat(minMovesToSeat(new int[]{4, 1, 5, 9}, new int[]{1, 3, 2, 6})).isEqualTo(7);
        Assertions.assertThat(minMovesToSeat(new int[]{2, 2, 6, 6}, new int[]{1, 3, 2, 6})).isEqualTo(4);
    }

    public int minMovesToSeat(int[] seats, int[] students) {
        int sum = 0;
        Arrays.sort(seats);
        Arrays.sort(students);
        for (int i = 0; i < seats.length; i++) {
            sum += Math.abs(seats[i] - students[i]);
        }
        return sum;
    }

}
