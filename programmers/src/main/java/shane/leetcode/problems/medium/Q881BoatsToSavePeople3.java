package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Q881BoatsToSavePeople3 {

    @Test
    public void test() {
        assertThat(numRescueBoats(new int[]{1, 2}, 3)).isEqualTo(1);
        assertThat(numRescueBoats(new int[]{3, 2, 2, 1}, 3)).isEqualTo(3);
        assertThat(numRescueBoats(new int[]{3, 2, 3, 2, 2}, 6)).isEqualTo(3);
    }

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int cnt = 0;
        for (int i = 0, j = people.length - 1; i <= j; j--, cnt++) {
            if (limit - people[j] >= people[i]) {
                i++;
            }
        }
        return cnt;
    }
}
