package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 12ms Beats92.35% 
 */
public class Q2337MovePiecestoObtainaString2 {

    @Test
    public void test() {
        assertThat(canChange("L_L__R__R_", "L___L___RR")).isFalse();
        assertThat(canChange("_L__R__R_", "L______RR")).isTrue();
        assertThat(canChange("_RRR", "____")).isFalse();
        assertThat(canChange("R_L_", "__LR")).isFalse();
        assertThat(canChange("R_", "_R")).isTrue();
        assertThat(canChange("R_", "LR")).isFalse();
        assertThat(canChange("R__L", "_LR_")).isFalse();
        assertThat(canChange("_R", "R_")).isFalse();
        assertThat(canChange("_R_L", "_RL_")).isTrue();
    }

    public boolean canChange(String start, String target) {
        final int LENGTH = start.length();
        int rCnt = 0;
        int lCnt = 0;
        for (int i = 0; i < LENGTH; i++) {
            char c1 = start.charAt(i);
            char c2 = target.charAt(i);
            if (c1 == '_') {
                if (c2 == 'R') {
                    rCnt--;
                    if (rCnt < 0)
                        return false;
                    continue;
                }
                if (c2 == '_')
                    continue;
                if (rCnt > 0)
                    return false;
                lCnt--;
                continue;
            }
            if (c1 == 'L') {
                if (rCnt > 0)
                    return false;
                if (c2 == 'L')
                    continue;
                if (c2 == 'R')
                    return false;
                if (lCnt == 0)
                    return false;
                lCnt++;
                continue;
            }
            // c1 == 'R'
            if (c2 == 'L')
                return false;
            if (c2 == '_')
                rCnt++;
        }
        return rCnt == 0 && lCnt == 0;
    }

}
