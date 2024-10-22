package shane.programmers.lv3;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class CollisionRisk {

    @Test
    public void test() {
        assertThat(solution(Ps.intArray("[[3, 2], [6, 4], [4, 7], [1, 4]]"), Ps.intArray("[[4, 2], [1, 3], [4, 2], [4, 3]]"))).isEqualTo(9);
        assertThat(solution(Ps.intArray("[[3, 2], [6, 4], [4, 7], [1, 4]]"), Ps.intArray("[[4, 2], [1, 3], [2, 4]]"))).isEqualTo(1);
        assertThat(solution(Ps.intArray("[[2, 2], [2, 3], [2, 7], [6, 6], [5, 2]]"), Ps.intArray("[[2, 3, 4, 5], [1, 3, 4, 5]]"))).isEqualTo(0);
    }

    public int solution(int[][] points, int[][] routes) {
        List<Robot> robots = new ArrayList<>();
        for (int[] route : routes) {
            robots.add(new Robot(route, points));
        }

        int cnt = 0;
        int arrivedCnt = 0;
        while (arrivedCnt < routes.length) {
            Set<String> collisions = new HashSet<>();
            Set<String> visited = new HashSet<>();
            for (Robot robot : robots) {
                if (!visited.add(robot.toString())) {
                    collisions.add(robot.toString());
                }
            }
            cnt += collisions.size();
            for (Robot robot : new ArrayList<>(robots)) {
                if (robot.goals.isEmpty()) {
                    arrivedCnt++;
                    robots.remove(robot);
                }
            }
            for (Robot robot : robots) {
                robot.move();
            }
        }

        return cnt;
    }

    static class Robot {
        int y;
        int x;
        int goalY;
        int goalX;
        List<int[]> goals = new ArrayList<>();

        @Override
        public String toString() {
            return y + "," + x;
        }

        public Robot(int[] routes, int[][] points) {
            this.y = points[routes[0] - 1][0];
            this.x = points[routes[0] - 1][1];
            for (int i = 1; i < routes.length; i++) {
                goals.add(points[routes[i] - 1]);
            }
            this.goalY = goals.get(0)[0];
            this.goalX = goals.get(0)[1];
        }

        public void move() {
            boolean moved = false;
            if (this.y != goalY) {
                if (this.y < goalY) {
                    this.y++;
                } else {
                    this.y--;
                }
                moved = true;
            }
            if (!moved && this.x != goalX) {
                if (this.x < goalX) {
                    this.x++;
                } else {
                    this.x--;
                }
            }
            if (this.y == goalY && this.x == goalX) {
                goals.remove(0);
                if (!goals.isEmpty()) {
                    int[] nextGoal = goals.get(0);
                    this.goalY = nextGoal[0];
                    this.goalX = nextGoal[1];
                }
            }
        }
    }
}
