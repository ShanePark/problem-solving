package shane.programmers.sk2022;

import com.tistory.shanepark.STool;
import org.junit.jupiter.api.Test;

public class Q2 {

    @Test
    void test() {
        STool.printDeepArray(solution(5, true));
//        STool.printDeepArray(solution(6, false));
//        STool.printDeepArray(solution(9, false));
    }

    public int[][] solution(int n, boolean clockwise) {
        int[][] answer = new int[n][n];
        answer[0][0] = 1;
        answer[0][n - 1] = 1;
        answer[n - 1][0] = 1;
        answer[n - 1][n - 1] = 1;

        Tornado t1 = new Tornado(0, 0, clockwise);
        Tornado t2 = new Tornado(0, n - 1, clockwise);
        Tornado t3 = new Tornado(n - 1, 0, clockwise);
        Tornado t4 = new Tornado(n - 1, n - 1, clockwise);

        if (clockwise) {
            t1.right(answer, 1);
            t2.down(answer, 1);
            t3.up(answer, 1);
            t4.left(answer, 1);
        } else {
            t1.down(answer, 1);
            t2.left(answer, 1);
            t3.right(answer, 1);
            t4.up(answer, 1);
        }

        return answer;
    }

    class Tornado {
        int y;
        int x;
        boolean clockwise;

        public Tornado(int y, int x, boolean clockwise) {
            this.y = y;
            this.x = x;
            this.clockwise = clockwise;
        }

        public void left(int[][] answer, int cnt) {
            if (cnt == answer.length - 1) {
                return;
            }
            int num = answer[y][x];
            for (int i = 0; i < answer.length - cnt; i++) {
                this.x--;
                answer[y][x] = num++;
            }
            if (clockwise) {
                up(answer, cnt + 1);
            } else {
                down(answer, cnt + 1);
            }
        }

        public void right(int[][] answer, int cnt) {
            if (cnt == answer.length - 1) {
                return;
            }
            int num = answer[y][x];
            for (int i = 0; i < answer.length - cnt; i++) {
                this.x++;
                answer[y][x] = num++;
            }
            if (clockwise) {
                down(answer, cnt + 1);
            } else {
                up(answer, cnt + 1);
            }
        }

        public void up(int[][] answer, int cnt) {
            if (cnt == answer.length - 1) {
                return;
            }
            for (int i = 0; i < answer.length - cnt; i++) {

            }
            if (clockwise) {
                right(answer, cnt + 1);
            } else {
                left(answer, cnt + 1);
            }
        }

        public void down(int[][] answer, int cnt) {
            if (cnt == answer.length - 1) {
                return;
            }
            for (int i = 0; i < answer.length - cnt; i++) {

            }
            if (clockwise) {
                left(answer, cnt + 1);
            } else {
                right(answer, cnt + 1);
            }
        }

    }
}
