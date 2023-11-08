package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 1ms Beats 95.30%of users with Java
 * Memory Details 39.23MB Beats 96.99%of users with Java
 */
public class Q2849DetermineIfACellIsReachableAtAGivenTime {

    @Test
    public void test() {
        assertThat(isReachableAtTime(1, 1, 1, 1, 3)).isTrue();
        assertThat(isReachableAtTime(1, 2, 1, 2, 1)).isFalse();
        assertThat(isReachableAtTime(1, 2, 1, 2, 2)).isTrue();
        assertThat(isReachableAtTime(0, 0, 3, 4, 4)).isTrue();
        assertThat(isReachableAtTime(2, 4, 7, 7, 6)).isTrue();
        assertThat(isReachableAtTime(3, 1, 7, 3, 3)).isFalse();
    }

    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int distanceX = Math.abs(fx - sx);
        int distanceY = Math.abs(fy - sy);
        if (distanceX + distanceY == 0 && t == 1)
            return false;
        if (t < distanceX)
            return false;
        if (t < distanceY)
            return false;
        return true;
    }

}
