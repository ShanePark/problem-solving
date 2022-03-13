package shane.leetcode.problems.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * TODO
 */
public class Q2120ExecutionOfAllSuffixInstructionsStayingInAGrid {

    @Test
    void test() {
        Assertions.assertThat(executeInstructions(3, new int[]{0, 1}, "RRDDLU")).containsExactly(1, 5, 4, 3, 1, 0);
        Assertions.assertThat(executeInstructions(2, new int[]{1, 1}, "LURD")).containsExactly(4,1,0,0);
        Assertions.assertThat(executeInstructions(1, new int[]{0, 0}, "LRUD")).containsExactly(0,0,0,0);
    }

    public int[] executeInstructions(int n, int[] startPos, String s) {
        int[] answer = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            int cnt = 0;
            int y = startPos[0];
            int x = startPos[1];

            for (int j = i; j < s.length(); j++) {
                switch (s.charAt(j)) {
                    case 'R':
                        x++;
                        break;
                    case 'L':
                        x--;
                        break;
                    case 'D':
                        y++;
                        break;
                    case 'U':
                        y--;
                        break;
                }
                if (x < 0 || y < 0 || x >= n || y >= n) {
                    break;
                }
                cnt++;
            }
            answer[i] = cnt;
        }
        return answer;
    }
}
