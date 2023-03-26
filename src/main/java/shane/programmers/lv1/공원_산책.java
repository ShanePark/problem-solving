package shane.programmers.lv1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class 공원_산책 {

    @Test
    void test() {
        assertThat(solution(new String[]{"SOO", "OXX", "OOO"}, new String[]{"E 2", "S 2", "W 1"})).containsExactly(0, 1);
        assertThat(solution(new String[]{"SOO", "OOO", "OOO"}, new String[]{"E 2", "S 2", "W 1"})).containsExactly(2, 1);
        assertThat(solution(new String[]{"OSO", "OOO", "OXO", "OOO"}, new String[]{"E 2", "S 3", "W 1"})).containsExactly(0, 0);
    }

    public int[] solution(String[] park, String[] routes) {
        int height = park.length;
        int width = park[0].length();
        char[][] arr = new char[height][width];
        int[] cur = null;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                arr[i][j] = park[i].charAt(j);
                if (arr[i][j] == 'S') {
                    cur = new int[]{i, j};
                }
            }
        }
        for (String route : routes) {
            cur = move(arr, cur, route);
        }
        return cur;
    }

    private int[] move(char[][] arr, int[] before, String route) {
        int[] moves = new int[]{0, 0};
        String[] move = route.split(" ");
        switch (move[0]) {
            case "E":
                moves[1]++;
                break;
            case "W":
                moves[1]--;
                break;
            case "N":
                moves[0]--;
                break;
            case "S":
                moves[0]++;
                break;
            default:
                throw new IllegalArgumentException();
        }
        int[] cur = new int[]{before[0], before[1]};
        int moveCnt = Integer.parseInt(move[1]);
        for (int i = 0; i < moveCnt; i++) {
            cur[0] += moves[0];
            cur[1] += moves[1];
            if (cur[0] < 0 || cur[1] < 0 || arr.length <= cur[0] || arr[0].length <= cur[1] || arr[cur[0]][cur[1]] == 'X') {
                return before;
            }
        }
        return cur;
    }

}
