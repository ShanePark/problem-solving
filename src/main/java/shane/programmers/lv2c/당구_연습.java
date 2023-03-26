package shane.programmers.lv2c;

import io.github.shanepark.Ps;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class 당구_연습 {

    @Test
    public void test() {
        Assertions.assertThat(solution(10, 10, 3, 7, Ps.intArray("[[7, 7]]"))).containsExactly(52);
        Assertions.assertThat(solution(10, 10, 3, 7, Ps.intArray("[[2, 7]]"))).containsExactly(37);
        Assertions.assertThat(solution(10, 10, 3, 7, Ps.intArray("[[7, 3]]"))).containsExactly(116);
        Assertions.assertThat(solution(10, 10, 3, 7, Ps.intArray("[[4, 1]]"))).containsExactly(65);
        Assertions.assertThat(solution(10, 10, 3, 7, Ps.intArray("[[3,3]]"))).containsExactly(52);
        Assertions.assertThat(solution(10, 10, 3, 7, Ps.intArray("[[1,6]]"))).containsExactly(17);
        Assertions.assertThat(solution(10, 10, 9, 5, Ps.intArray("[[8,3]]"))).containsExactly(13);
    }

    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        Arrays.fill(answer, Integer.MAX_VALUE);
        for (int i = 0; i < balls.length; i++) {
            int[] ball = balls[i];
            int distanceX = Math.abs(startX - ball[0]);
            int distanceY = Math.abs(startY - ball[1]);

            // down vertical
            if (distanceX != 0 || startY < ball[1]) {
                int yDistance = startY + ball[1];
                answer[i] = Math.min(answer[i], yDistance * yDistance + distanceX * distanceX);
            }

            // top vertical
            if (distanceX != 0 || ball[1] < startY) {
                int yDistance = 2 * n - startY - ball[1];
                answer[i] = Math.min(answer[i], yDistance * yDistance + distanceX * distanceX);
            }

            // left horizontal
            if (distanceY != 0 || startX < ball[0]) {
                int xDistance = startX + ball[0];
                answer[i] = Math.min(answer[i], xDistance * xDistance + distanceY * distanceY);
            }

            // right horizontal
            if (distanceY != 0 || ball[0] < startX) {
                int xDistance = 2 * m - startX - ball[0];
                answer[i] = Math.min(answer[i], xDistance * xDistance + distanceY * distanceY);
            }
        }
        return answer;
    }
}
