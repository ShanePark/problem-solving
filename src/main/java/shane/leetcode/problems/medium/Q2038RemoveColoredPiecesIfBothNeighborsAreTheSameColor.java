package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 8ms Beats 93.26%of users with Java
 * Memory Details 44.20MB Beats 56.20%of users with Java
 */
public class Q2038RemoveColoredPiecesIfBothNeighborsAreTheSameColor {

    @Test
    public void test() {
        assertThat(winnerOfGame("AAAABBBB")).isFalse();
        assertThat(winnerOfGame("AAABABB")).isTrue();
        assertThat(winnerOfGame("AA")).isFalse();
        assertThat(winnerOfGame("ABBBBBBBAAA")).isFalse();
    }

    public boolean winnerOfGame(String colors) {
        int a = 0;
        int b = 0;
        char before = ' ';
        int cnt = 0;
        for (char c : colors.toCharArray()) {
            if (c == before) {
                cnt++;
                continue;
            }
            int plus = Integer.max(0, cnt - 2);
            if (before == 'A') {
                a += plus;
            } else {
                b += plus;
            }
            before = c;
            cnt = 1;
        }
        int plus = Integer.max(0, cnt - 2);
        if (before == 'A') {
            a += plus;
        } else {
            b += plus;
        }
        return a > b;
    }

}
