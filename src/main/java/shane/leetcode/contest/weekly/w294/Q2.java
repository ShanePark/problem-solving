package shane.leetcode.contest.weekly.w294;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2 {

    @Test
    public void test() {
        assertThat(maximumBags(new int[]{2, 3, 4, 5}, new int[]{1, 2, 4, 4}, 2)).isEqualTo(3);
        assertThat(maximumBags(new int[]{10, 2, 2}, new int[]{2, 2, 0}, 100)).isEqualTo(3);
    }

    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        for (int i = 0; i < capacity.length; i++) {
            capacity[i] -= rocks[i];
        }

        Arrays.sort(capacity);

        int cnt = 0;

        for (int i = 0; i < rocks.length; i++) {
            if (additionalRocks < capacity[i]) {
                break;
            }
            additionalRocks -= capacity[i];
            cnt++;
        }

        return cnt;
    }

}
