package shane.programmers.devMatching2022Game;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q2 {

    @Test
    void test() {
        Assertions.assertThat(solution(7, 9, 4, new String[]{"111100000", "000010011", "111100011", "111110011", "111100011", "111100010", "111100000"})).isEqualTo(10);
        Assertions.assertThat(solution(5, 5, 5, new String[]{"11111", "11111", "11111", "11111", "11111"})).isEqualTo(12);
    }

    public int solution(int h, int w, int n, String[] board) {
        int cnt = 0;
        // 가로 세고
        for (int j = 0; j < h; j++) {
            for (int i = 0; i <= w - n; i++) {
                String substring = board[j].substring(i, i + n);
                if (!substring.contains("0")) {
                    if ((i == 0 || (board[j].charAt(i - 1) == '0')) && (i + n == w || board[j].charAt(i + n) == '0')) {
                        cnt++;
                    }
                }
            }
        }

        // 세로 세고
        for (int i = 0; i < w; i++) {
            for (int j = 0; j <= h - n; j++) {
                if ((j == 0 || board[j - 1].charAt(i) == '0') && ((j == h - n) || board[j + n].charAt(i) == '0')) {
                    boolean flag = true;
                    for (int k = 0; k < n; k++) {
                        if (board[j + k].charAt(i) == '0') {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        cnt++;
                    }
                }
            }
        }

        // 대각 우상
        for (int i = 0; i <= w - n; i++) {
            for (int j = n - 1; j < h; j++) {
                if ((i == 0 || j == h - 1 || board[j + 1].charAt(i - 1) == '0') && (i == w - n || j == n - 1 || board[j - n].charAt(i + n) == '0')) {
                    boolean flag = true;
                    for (int k = 0; k < n; k++) {
                        if (board[j - k].charAt(i + k) == '0') {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        cnt++;
                    }
                }
            }
        }

        // 대각 우하
        for (int i = 0; i <= w - n; i++) {
            for (int j = 0; j <= h - n; j++) {
                if ((i == 0 || j == 0 || board[j - 1].charAt(i - 1) == '0') && (i == w - n || j == h - n || board[j + n].charAt(i + n) == '0')) {
                    boolean flag = true;
                    for (int k = 0; k < n; k++) {
                        if (board[j + k].charAt(i + k) == '0') {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        cnt++;
                    }
                }
            }
        }

        return cnt;
    }
}
