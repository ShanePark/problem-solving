package shane.leetcode.contest.weekly.w301;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q3_2 {

    @Test
    public void test() {
        assertThat(canChange("_R", "L_")).isEqualTo(false);
        assertThat(canChange("R_L_", "__LR")).isEqualTo(false);
        assertThat(canChange("_L__R__R_", "L______RR")).isEqualTo(true);
        assertThat(canChange("R_", "_R")).isEqualTo(true);
        assertThat(canChange("_R", "R_")).isEqualTo(false);
        assertThat(canChange("__________LLLLLL", "LLLLLL__________")).isTrue();
    }

    @Test
    public void test2() {
        assertThat(canChange(
                "__RRR___RRL__L_RR__R___L___L__R_R__RL_R____L_LL_R_______L___R_LL_L__L_R_RLR_R___L___L__",
                "____R_RRRRLL___RR___RL____L___R_R__RL_R__L_LL________R_L____R_LL_L__L_R_RLR__R_L____L__")).isTrue();
    }

    public boolean canChange(String start, String target) {
        int l = 0;
        int r = 0;

        for (int i = 0; i < start.length(); i++) {
            char c1 = start.charAt(i);
            char c2 = target.charAt(i);
            if (c1 != c2) {
                if (c1 == 'L') {
                    if (l == 0 || r > 0) {
                        return false;
                    } else {
                        l++;
                    }
                }
                if (c1 == '_') {
                    if (c2 == 'R') {
                        if (r == 0)
                            return false;
                        r--;
                    } else {
                        l--;
                    }
                }
                if (c1 == 'R') {
                    if (c2 == 'L') {
                        return false;
                    }
                    r++;
                }
            } else if (l > 0) {
                return false;
            } else if (r > 0 && c2 == 'L') {
                return false;
            }
        }
        return l == 0 && r == 0;
    }

}
