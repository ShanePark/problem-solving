package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime0msBeats100.00%
 */
public class Q1550ThreeConsecutiveOdds {

    @Test
    public void test() {
        assertThat(threeConsecutiveOdds(new int[]{2, 6, 4, 1})).isFalse();
        assertThat(threeConsecutiveOdds(new int[]{1, 2, 34, 3, 4, 5, 7, 23, 12})).isTrue();
    }

    public boolean threeConsecutiveOdds(int[] arr) {
        int oddCnt = 0;
        for (int i : arr) {
            if (i % 2 == 1) {
                oddCnt++;
                if (oddCnt == 3)
                    return true;
                continue;
            }
            oddCnt = 0;
        }
        return false;
    }

}
