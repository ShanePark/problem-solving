package shane.programmers.challenge2022.backendq1;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 정확성 테스트
 * 테스트 1 〉 실패 (시간 초과)
 * 테스트 2 〉 통과 (239.07ms, 285MB)
 * 테스트 3 〉 통과 (52.26ms, 104MB)
 * 테스트 4 〉 통과 (55.62ms, 114MB)
 * 테스트 5 〉 통과 (121.19ms, 141MB)
 * 테스트 6 〉 통과 (7.48ms, 78.6MB)
 * 테스트 7 〉 통과 (7.56ms, 74.7MB)
 * 테스트 8 〉 통과 (2981.93ms, 399MB)
 * 채점 결과
 * 정확성: 86.5
 * 효율성: 0.0
 * 합계: 86.5 / 100.0
 */
public class Q2 {

    @Test
    public void test() {
        assertThat(valid(new char[][]{{'a','b','b'},{'a','b','c'},{'c','c','c'}})).isTrue();
        assertThat(solution(new String[]{"??b", "abc", "cc?"})).isEqualTo(2);
        assertThat(solution(new String[]{"aa?"})).isEqualTo(3);
        assertThat(solution(new String[]{"abcabcab", "????????"})).isEqualTo(0);
    }

    int SIZE_X;
    int SIZE_Y;

    public int solution(String[] grid) {
        SIZE_Y = grid.length;
        SIZE_X = grid[0].length();

        Set<int[]> unsetPoint = new HashSet<>();

        char[][] arr = new char[SIZE_Y][SIZE_X];
        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {
                arr[i][j] = grid[i].charAt(j);
                if (arr[i][j] == '?') {
                    unsetPoint.add(new int[]{i, j});
                }
            }
        }

        List<char[][]> possibilities = new ArrayList<>();
        possibilities.add(arr);

        for (int[] ints : unsetPoint) {
            int y = ints[0];
            int x = ints[1];
            List<char[][]> temp = new ArrayList<>();
            for (char[][] possibility : possibilities) {
                char tmp = possibility[y][x];
                possibility[y][x] = 'a';
                temp.add(copy(possibility));
                possibility[y][x] = 'b';
                temp.add(copy(possibility));
                possibility[y][x] = 'c';
                temp.add(copy(possibility));
                possibility[y][x] = tmp;
            }
            possibilities = temp;
        }

        int cnt = 0;

        for (char[][] possibility : possibilities) {
            if (valid(possibility)) {
                cnt++;
            }
        }
        return cnt;
    }

    private boolean valid(char[][] possibility) {
        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {
                char c = possibility[i][j];
                for (int i2 = 0; i2 < SIZE_Y; i2++) {
                    for (int j2 = 0; j2 < SIZE_X; j2++) {
                        char c2 = possibility[i2][j2];
                        if (c == c2) {
                            boolean canReach = canReach(possibility, i, j, i2, j2, c);
                            if (!canReach) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    private boolean canReach(char[][] possibility, int i, int j, int i2, int j2, char c) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        Set<String> set = new HashSet<>();
        while (!q.isEmpty()) {
            int[] poll = q.poll();

            int y = poll[0];
            int x = poll[1];

            if (!set.add(y + " " + x)) {
                continue;
            }

            if (y == i2 && x == j2) {
                return true;
            }

            // up
            if (y > 0 && possibility[y - 1][x] == c)
                q.add(new int[]{y - 1, x});
            // down
            if (y < SIZE_Y - 1 && possibility[y + 1][x] == c)
                q.add(new int[]{y + 1, x});
            // left
            if (x > 0 && possibility[y][x - 1] == c)
                q.add(new int[]{y, x - 1});

            //right
            if (x < SIZE_X - 1 && possibility[y][x + 1] == c)
                q.add(new int[]{y, x + 1});
        }
        return false;
    }

    private char[][] copy(char[][] possibility) {
        char[][] arr = new char[SIZE_Y][SIZE_X];
        for (int i = 0; i < SIZE_Y; i++) {
            arr[i] = Arrays.copyOf(possibility[i], SIZE_X);
        }
        return arr;
    }

}
