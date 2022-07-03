package shane.programmers.challenge2022.backendq2;

import com.tistory.shanepark.STool;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2 {

    @Test
    public void test() {
        assertThat(solution(4, true)).isDeepEqualTo(STool.convertToIntArray("[[1,2,9,10],[4,3,8,11],[5,6,7,12],[16,15,14,13]]"));
    }

    int cnt = 2;

    public int[][] solution(int n, boolean horizontal) {
        cnt = 2;
        int[][] answer = new int[n][n];
        int y = 0;
        int x = 0;
        answer[0][0] = 1;

        while (x != n - 1 && y != n - 1) {
            if (horizontal) {
                x = moveRight(y, x, answer);
                y = straightDown(y, x, answer);
                x = straightLeft(y, x, answer);
            } else {
                y = moveDown(y, x, answer);
                x = straightRight(y, x, answer);
                y = straightUp(y, x, answer);
            }
            horizontal = !horizontal;
        }

        return answer;
    }

    private int straightUp(int y, int x, int[][] answer) {
        for (int i = 0; i < x; i++) {
            answer[--y][x] = cnt++;
        }
        return y;
    }

    private int straightRight(int y, int x, int[][] answer) {
        for (int i = 0; i < y; i++) {
            answer[y][++x] = cnt++;
        }
        return x;
    }

    private int straightLeft(int y, int x, int[][] answer) {
        for (int i = 0; i < y; i++) {
            answer[y][--x] = cnt++;
        }
        return x;
    }

    private int straightDown(int y, int x, int[][] answer) {
        for (int i = 0; i < x; i++) {
            answer[++y][x] = cnt++;
        }
        return y;
    }

    private int moveDown(int y, int x, int[][] answer) {
        answer[y + 1][x] = cnt++;
        return y + 1;
    }

    private int moveRight(int y, int x, int[][] answer) {
        answer[y][x + 1] = cnt++;
        return x + 1;
    }


}
