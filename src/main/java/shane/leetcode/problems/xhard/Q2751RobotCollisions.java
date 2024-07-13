package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime65msBeats30.00%
 */
public class Q2751RobotCollisions {

    @Test
    public void test() {
        assertThat(survivedRobotsHealths(new int[]{1, 40}, new int[]{10, 11}, "RL")).containsExactly(10);
        assertThat(survivedRobotsHealths(new int[]{5, 4, 3, 2, 1}, new int[]{2, 17, 9, 15, 10}, "RRRRR")).containsExactly(2, 17, 9, 15, 10);
        assertThat(survivedRobotsHealths(new int[]{3, 5, 2, 6}, new int[]{10, 10, 15, 12}, "RLRL")).containsExactly(14);
        assertThat(survivedRobotsHealths(new int[]{1, 2, 5, 6}, new int[]{10, 10, 11, 11}, "RLRL")).isEmpty();
    }

    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        List<Robot> robots = new ArrayList<>();
        for (int i = 0; i < positions.length; i++) {
            Robot robot = new Robot(i, positions[i], healths[i], directions.charAt(i));
            robots.add(robot);
        }
        Collections.sort(robots);
        Stack<Robot> stack = new Stack<>();
        for (Robot robot : robots) {
            if (stack.isEmpty() || stack.peek().direction == 'L' || robot.direction == 'R') {
                stack.push(robot);
                continue;
            }
            while (!stack.isEmpty() && stack.peek().direction == 'R') {
                Robot last = stack.pop();
                if (last.health == robot.health) {
                    robot.health = 0;
                    break;
                }
                if (last.health > robot.health) {
                    last.health--;
                    robot.health = 0;
                    stack.push(last);
                    break;
                }
                robot.health--;
            }
            if (robot.health > 0) {
                stack.push(robot);
            }
        }
        return stack.stream()
                .sorted(Comparator.comparingInt(r -> r.index))
                .map(r -> r.health)
                .collect(Collectors.toList());
    }

    static class Robot implements Comparable<Robot> {
        int index;
        int position;
        int health;
        char direction;

        public Robot(int i, int position, int health, char c) {
            this.index = i;
            this.position = position;
            this.health = health;
            this.direction = c;
        }

        @Override
        public int compareTo(Robot o) {
            return Integer.compare(this.position, o.position);
        }

        @Override
        public String toString() {
            return "Robot{" +
                    "index=" + index +
                    ", position=" + position +
                    ", health=" + health +
                    ", direction=" + direction +
                    '}';
        }
    }

}
