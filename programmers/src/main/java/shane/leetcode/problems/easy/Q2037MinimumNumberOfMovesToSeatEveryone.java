package shane.leetcode.problems.easy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Q2037MinimumNumberOfMovesToSeatEveryone {

    @Test
    void test() {
        Assertions.assertThat(minMovesToSeat(new int[]{3, 1, 5}, new int[]{2, 7, 4})).isEqualTo(4);
    }

    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int sum = 0;
        for (int i = 0; i < seats.length; i++) {
            sum += Math.abs(seats[i] - students[i]);
        }
        return sum;
    }
}
