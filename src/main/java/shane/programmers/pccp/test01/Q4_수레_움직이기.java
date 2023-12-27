package shane.programmers.pccp.test01;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 0	빈칸
 * 1	빨간 수레의 시작 칸
 * 2	파란 수레의 시작 칸
 * 3	빨간 수레의 도착 칸
 * 4	파란 수레의 도착 칸
 * 5	벽
 */
public class Q4_수레_움직이기 {

    @Test
    public void test() {
        assertThat(solution(Ps.intArray("[[1, 4], [0, 0], [2, 3]]"))).isEqualTo(3);
        assertThat(solution(Ps.intArray("[[1, 0, 2], [0, 0, 0], [5, 0 ,5], [4, 0, 3]]"))).isEqualTo(7);
        assertThat(solution(Ps.intArray("[[1, 5], [2, 5], [4, 5], [3, 5]]"))).isEqualTo(0);
        assertThat(solution(Ps.intArray("[[4, 1, 2, 3]]"))).isEqualTo(0);
    }

    public int solution(int[][] maze) {
        Car[] start = new Car[2];
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if (maze[i][j] == 1) {
                    start[0] = new Car(i, j, 1);
                } else if (maze[i][j] == 2) {
                    start[1] = new Car(i, j, 2);
                }
            }
        }
        Queue<Car[]> q = new LinkedList<>();
        q.offer(start);

        int time = 0;
        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                Car[] poll = q.poll();
                Car red = poll[0];
                Car blue = poll[1];
                if (red.finished && blue.finished) {
                    return time;
                }
                // move
                List<Car> redMoves = red.getMoves(maze);
                List<Car> blueMoves = blue.getMoves(maze);

                for (Car redMove : redMoves) {
                    for (Car blueMove : blueMoves) {
                        if (redMove.same(blueMove) || (redMove.same(blue) && blueMove.same(red))) {
                            continue;
                        }
                        q.offer(new Car[]{redMove, blueMove});
                    }
                }
            }
            time++;
        }

        return 0;
    }

    static final int[][] DIRS = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    class Car {
        int y;
        int x;
        int color;
        Set<String> visited = new HashSet<>();
        boolean finished = false;

        public Car(int y, int x, int color) {
            this.y = y;
            this.x = x;
            this.color = color;
            this.visited.add(y + " " + x);
        }

        public boolean same(Car car) {
            return this.y == car.y && this.x == car.x;
        }

        public List<Car> getMoves(int[][] maze) {
            List<Car> answer = new ArrayList<>();
            if (this.finished) {
                answer.add(this);
                return answer;
            }
            for (int[] DIR : DIRS) {
                int nextY = y + DIR[0];
                int nextX = x + DIR[1];
                if (nextX < 0 || nextY < 0 || nextY == maze.length || nextX == maze[0].length || maze[nextY][nextX] == 5 || visited.contains(nextY + " " + nextX)) {
                    continue;
                }
                Car next = new Car(nextY, nextX, this.color);
                next.visited.addAll(this.visited);
                next.visited.add(nextY + " " + nextX);
                if (this.color + 2 == maze[nextY][nextX]) {
                    next.finished = true;
                }
                answer.add(next);
            }
            return answer;
        }

        @Override
        public String toString() {
            return "Car{" +
                    "y=" + y +
                    ", x=" + x +
                    ", color=" + color +
                    ", visited=" + visited +
                    ", finished=" + finished +
                    '}';
        }
    }

}


