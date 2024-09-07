package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime36msBeats42.79%
 */
public class Q874WalkingRobotSimulation {

    @Test
    public void test() {
        assertThat(robotSim(new int[]{6, -1, -1, 6}, new int[][]{})).isEqualTo(36);
        assertThat(robotSim(new int[]{4, -1, 4, -2, 4}, new int[][]{{2, 4}})).isEqualTo(65);
        assertThat(robotSim(new int[]{4, -1, 3}, new int[][]{})).isEqualTo(25);
    }

    final int[][] DIRS = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> blocks = new HashSet<>();
        for (int[] obstacle : obstacles) {
            blocks.add(obstacle[1] + " " + obstacle[0]);
        }
        int curDir = 0;
        int y = 0;
        int x = 0;
        int max = 0;
        for (int command : commands) {
            if (command == -1) {
                curDir++;
                curDir %= 4;
                continue;
            }
            if (command == -2) {
                curDir--;
                if (curDir < 0)
                    curDir = 3;
                continue;
            }
            for (int i = 0; i < command; i++) {
                int nextY = y + DIRS[curDir][0];
                int nextX = x + DIRS[curDir][1];
                if (blocks.contains(nextY + " " + nextX)) {
                    break;
                }
                y = nextY;
                x = nextX;
                max = Math.max(max, y * y + x * x);
            }
        }
        return max;
    }

}
