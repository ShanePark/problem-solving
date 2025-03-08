package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime1msBeats92.10%
 */
public class Q2379MinimumRecolorsToGetKConsecutiveBlackBlocks {

    @Test
    public void test() {
        assertThat(minimumRecolors("WBBWWBBWBW", 7)).isEqualTo(3);
        assertThat(minimumRecolors("WBWBBBW", 2)).isEqualTo(0);
        assertThat(minimumRecolors("WWBBBWBBBBBWWBWWWB", 16)).isEqualTo(6);
    }

    public int minimumRecolors(String blocks, int k) {
        int whiteCnt = 0;
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W')
                whiteCnt++;
        }
        int min = whiteCnt;
        for (int i = 1; i + k <= blocks.length(); i++) {
            if (blocks.charAt(i - 1) == 'W')
                whiteCnt--;
            if (blocks.charAt(i + k - 1) == 'W')
                whiteCnt++;
            min = Math.min(min, whiteCnt);
        }
        return min;
    }

}
