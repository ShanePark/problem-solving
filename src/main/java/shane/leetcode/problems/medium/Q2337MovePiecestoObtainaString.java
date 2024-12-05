package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 1453ms Beats5.29%
 */
public class Q2337MovePiecestoObtainaString {

    @Test
    public void test() {
        assertThat(canChange("R_", "LR")).isFalse();
        assertThat(canChange("R__L", "_LR_")).isFalse();
        assertThat(canChange("_L__R__R_", "L______RR")).isTrue();
        assertThat(canChange("R_L_", "__LR")).isFalse();
        assertThat(canChange("_R", "R_")).isFalse();
        assertThat(canChange("_R_L", "_RL_")).isTrue();
        assertThat(canChange("_RRR", "____")).isFalse();
    }

    public boolean canChange(String start, String target) {
        char[] startArr = start.toCharArray();
        char[] targetArr = target.toCharArray();
        int LENGTH = startArr.length;
        int rCount = 0;
        for (int i = 0; i < LENGTH; i++) {
            char c1 = startArr[i];
            char c2 = targetArr[i];
            if (c1 == 'L' && rCount > 0)
                return false;
            if (c1 == c2)
                continue;
            if (c1 == 'R') {
                if (c2 != '_')
                    return false;
                rCount++;
                continue;
            }
            // c1 == '_'
            if (c2 == '_')
                return false;
            if (c2 == 'R') {
                if (rCount == 0)
                    return false;
                rCount--;
                continue;
            }
            if (rCount > 0)
                return false;
            if (!findLAndSwap(startArr, i)) {
                return false;
            }
        }
        return rCount == 0;
    }

    private boolean findLAndSwap(char[] startArr, int i) {
        for (; i < startArr.length; i++) {
            char c = startArr[i];
            if (c == '_')
                continue;
            if (c == 'R')
                return false;
            startArr[i] = '_';
            return true;
        }
        return false;
    }

}
