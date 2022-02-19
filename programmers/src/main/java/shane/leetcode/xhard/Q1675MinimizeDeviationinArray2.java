package shane.leetcode.xhard;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

/**
 * TLE
 */
@SuppressWarnings("ALL")
public class Q1675MinimizeDeviationinArray2 {

    @Test
    void test() {
        Assertions.assertThat(minimumDeviation(new int[]{1, 2, 3, 4})).isEqualTo(1);
        Assertions.assertThat(minimumDeviation(new int[]{4, 1, 5, 20, 3})).isEqualTo(3);
        Assertions.assertThat(minimumDeviation(new int[]{2, 10, 8})).isEqualTo(3);
        Assertions.assertThat(minimumDeviation(new int[]{3, 5})).isEqualTo(1);
        Assertions.assertThat(minimumDeviation(new int[]{2, 4})).isEqualTo(0);
        Assertions.assertThat(minimumDeviation(new int[]{8, 6, 1, 6})).isEqualTo(1);
        Assertions.assertThat(minimumDeviation(new int[]{10, 4, 3})).isEqualTo(2);
        Assertions.assertThat(minimumDeviation(new int[]{399, 908, 648, 357, 693, 502, 331, 649, 596, 698})).isEqualTo(315);
        Assertions.assertThat(minimumDeviation(new int[]{9, 4, 3, 6, 2})).isEqualTo(7);
    }

    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        int min = Integer.MAX_VALUE;
        int answer = Integer.MAX_VALUE;

        for (int n : nums) {
            if (n % 2 == 1)
                n *= 2;
            q.add(n);
            min = Math.min(min, n);
        }

        while (true) {
            int max = q.poll();
            answer = Math.min(answer, max - min);
            if (max % 2 == 1) {
                break;
            }
            q.add(max / 2);
            min = Math.min(min, max / 2);
        }

        return answer;
    }

}
