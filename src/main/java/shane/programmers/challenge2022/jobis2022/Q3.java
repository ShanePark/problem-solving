package shane.programmers.challenge2022.jobis2022;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q3 {

    @Test
    public void test() {
        assertThat(solution(new String[]{"EEEEE", "EEMEE", "EEEEE", "EEEEE"}, 2, 0)).containsExactly("B1E1B", "B1E1B", "B111B", "BBBBB");
        assertThat(solution(new String[]{"MME", "EEE", "EME"}, 0, 0)).containsExactly("XME", "EEE", "EME");

    }

    public String[] solution(String[] board, int y, int x) {

        // Given
        final int HEIGHT = board.length;
        final int WIDTH = board[0].length();
        char[][] arr = new char[HEIGHT][WIDTH];
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                arr[i][j] = board[i].charAt(j);
            }
        }

        String[] answer = new String[HEIGHT];

        if (arr[y][x] == 'M') {
            arr[y][x] = 'X';
            for (int i = 0; i < HEIGHT; i++) {
                answer[i] = String.valueOf(arr[i]);
            }
            return answer;
        }

        // When
        click(arr, y, x);

        // Then
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (arr[i][j] == 'M') {
                    arr[i][j] = 'E';
                }
            }
            answer[i] = String.valueOf(arr[i]);
        }
        return answer;
    }

    private void click(char[][] arr, int y, int x) {
        int cntBomb = 0;
        int[] ints = new int[]{-1, 0, 1};
        for (int i : ints) {
            for (int j : ints) {
                if (i == 0 && j == 0) continue;
                int curY = y + i;
                int curX = x + j;
                if (0 <= curY && curY < arr.length && 0 <= curX && curX < arr[0].length) {
                    cntBomb += arr[curY][curX] == 'M' ? 1 : 0;
                }
            }
        }
        if (cntBomb > 0) {
            arr[y][x] = (char) ('0' + cntBomb);
        } else {
            arr[y][x] = 'B';
            for (int i : ints) {
                for (int j : ints) {
                    if (i == 0 && j == 0) continue;
                    int curY = y + i;
                    int curX = x + j;
                    if (0 <= curY && curY < arr.length && 0 <= curX && curX < arr[0].length && arr[curY][curX] == 'E') {
                        click(arr, curY, curX);
                    }
                }
            }
        }
    }

}
