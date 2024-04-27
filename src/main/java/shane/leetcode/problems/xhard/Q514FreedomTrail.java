package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q514FreedomTrail {

    @Test
    public void test() {
        assertThat(findRotateSteps("godding", "gd")).isEqualTo(4);
        assertThat(findRotateSteps("godding", "godding")).isEqualTo(13);
        assertThat(findRotateSteps("aaaaa", "aaaaa")).isEqualTo(5);
    }

    /**
     * 16 sec 313 ms. i think it should converted to BFS
     */
    @Test
    public void tle() {
        assertThat(findRotateSteps("fjghcgmfli", "hjgfjgmmighfcghgjlhifcgicgmgjihhffchglflgiclffhiggcicjmfmfghhffllifglggfjjgcmgjglcijfffmfflgijmcflmm")).isEqualTo(318);
    }

    public int findRotateSteps(String ring, String key) {
        int[][] dp = new int[key.length() + 1][ring.length()];
        for (int[] ints : dp) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }
        dial(dp, ring, key, 0, 0, 0);
        return Arrays.stream(dp[key.length()]).min().getAsInt();
    }

    private void dial(int[][] dp, String ring, String key, int dial, int index, int move) {
        dp[index][dial] = move;
        if (index == key.length()) {
            return;
        }
        if (ring.charAt(dial) == key.charAt(index)) {
            dial(dp, ring, key, dial, index + 1, move + 1);
            return;
        }
        // dial left
        int leftDial = (ring.length() + dial - 1) % ring.length();
        if (move < dp[index][leftDial]) {
            dial(dp, ring, key, leftDial, index, move + 1);
        }

        // dial right
        int rightDial = (ring.length() + dial + 1) % ring.length();
        if (move < dp[index][rightDial]) {
            dial(dp, ring, key, rightDial, index, move + 1);
        }
    }

}
