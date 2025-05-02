package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 30ms
 * Beats22.26%
 */
public class Q838PushDominoes2 {

    @Test
    public void test() {
        assertThat(pushDominoes(".L.R...LR..L..")).isEqualTo("LL.RR.LLRRLL..");
        assertThat(pushDominoes("RR.L")).isEqualTo("RR.L");
    }

    public String pushDominoes(String dominoes) {
        final int SIZE = dominoes.length();
        int[] toRight = new int[SIZE];
        int distance = 0;
        for (int i = 0; i < SIZE; i++) {
            switch (dominoes.charAt(i)) {
                case '.':
                    distance = distance == 0 ? 0 : distance + 1;
                    break;
                case 'L':
                    distance = 0;
                    break;
                case 'R':
                    distance = 1;
                    break;
            }
            toRight[i] = distance;
        }

        distance = 0;
        int[] toLeft = new int[SIZE];
        for (int i = SIZE - 1; i >= 0; i--) {
            switch (dominoes.charAt(i)) {
                case '.':
                    distance = distance == 0 ? 0 : distance + 1;
                    break;
                case 'R':
                    distance = 0;
                    break;
                case 'L':
                    distance = 1;
                    break;
            }
            toLeft[i] = distance;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < SIZE; i++) {
            if (toRight[i] == toLeft[i]) {
                sb.append(".");
                continue;
            }
            if (toRight[i] == 0) {
                sb.append("L");
                continue;
            }
            if (toLeft[i] == 0) {
                sb.append("R");
                continue;
            }
            sb.append(toLeft[i] < toRight[i] ? "L" : "R");
        }
        return sb.toString();
    }

}
