package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 17 ms Beats 98.31%
 * Memory 51.1 MB Beats 15.64%
 */
public class Q881BoatsToSavePeople4 {

    @Test
    public void test() {
        assertThat(numRescueBoats(new int[]{2, 49, 10, 7, 11, 41, 47, 2, 22, 6, 13, 12, 33, 18, 10, 26, 2, 6, 50, 10}, 50)).isEqualTo(11);
        assertThat(numRescueBoats(new int[]{2, 2}, 6)).isEqualTo(1);
        assertThat(numRescueBoats(new int[]{1, 2}, 3)).isEqualTo(1);
        assertThat(numRescueBoats(new int[]{3, 2, 2, 1}, 3)).isEqualTo(3);
        assertThat(numRescueBoats(new int[]{3, 2, 3, 2, 2}, 6)).isEqualTo(3);
    }

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int cnt = 0;
        for (int left = 0, right = people.length - 1; left <= right; right--, cnt++) {
            if (people[right] + people[left] <= limit) {
                left++;
            }
        }
        return cnt;
    }

}
