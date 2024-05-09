package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 33 ms Beats 99.96% of users with Java
 */
public class Q3075MaximizeHappinessOfSelectedChildren {

    @Test
    public void test() {
        assertThat(maximumHappinessSum(new int[]{1, 2, 3}, 2)).isEqualTo(4);
        assertThat(maximumHappinessSum(new int[]{1, 1, 1, 1}, 2)).isEqualTo(1);
        assertThat(maximumHappinessSum(new int[]{2, 3, 4, 5}, 1)).isEqualTo(5);
    }

    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long sum = 0;
        for (int i = 0; i < k; i++) {
            int happy = happiness[happiness.length - 1 - i] - i;
            if (happy <= 0)
                break;
            sum += happy;
        }
        return sum;
    }

}
