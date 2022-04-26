package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q657RobotReturnToOrigin {

    @Test
    public void test() {
        assertThat(judgeCircle("UD")).isTrue();
        assertThat(judgeCircle("LL")).isFalse();
        assertThat(judgeCircle("")).isTrue();
    }

    public boolean judgeCircle(String moves) {
        int[] location = new int[2];
        for (int i = 0; i < moves.length(); i++) {
            switch (moves.charAt(i)) {
                case 'U':
                    location[0]--;
                    break;
                case 'D':
                    location[0]++;
                    break;
                case 'L':
                    location[1]--;
                    break;
                case 'R':
                    location[1]++;
                    break;
            }
        }
        return location[0] == 0 && location[1] == 0;
    }
}
