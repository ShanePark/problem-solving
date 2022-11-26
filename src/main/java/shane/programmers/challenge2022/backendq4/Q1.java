package shane.programmers.challenge2022.backendq4;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * passed TC but failed
 */
public class Q1 {

    @Test
    public void test() {
        assertThat(solution(25, 51, new String[]{".########......", ".####...#......", ".#.####.#.#####", ".#.#..#.#.#..##", ".#.##.#.#.#...#", ".#.####.#.#...#", ".#....###.#####", ".########......"}))
                .isEqualTo(2);
    }

    @Test
    public void test2() {
        assertThat(solution(25, 50, new String[]{
                ".########......",
                ".####...#......",
                ".#.####.#.#####",
                ".#.#..#.#.#..##",
                ".#.##.#.#.#...#",
                ".#.####.#.#...#",
                ".#....###.#####",
                ".########......"
        }))
                .isEqualTo(1);
    }

    public int solution(int low, int high, String[] img) {
        int height = img.length;
        int width = img[0].length();
        int cnt = 0;
        for (int i = 0; i < height - 2; i++) {
            for (int j = 0; j < width - 2; j++) {
                char start = img[i].charAt(j);
                if (start != '#')
                    continue;
                for (int right = j + 1; right < width && right - j <= 50; right++) {
                    for (int down = i + 1; down < height && down - i <= 50; down++) {
                        if (check(i, j, down, right, low, high, img)) {
                            cnt++;
                        }
                    }
                }
            }
        }
        return cnt;
    }

    private boolean check(int top, int left, int down, int right, int low, int high, String[] img) {
        if (right - left <= 2 || down - top <= 2)
            return false;
        for (int i = top + 1; i <= down; i++) {
            if (img[i].charAt(right) != '#' || img[i].charAt(left) != '#')
                return false;
        }
        for (int j = left + 1; j <= right; j++) {
            if (img[down].charAt(j) != '#' || img[top].charAt(j) != '#')
                return false;
        }

        int black = 0;
        int white = 0;
        for (int i = top + 1; i < down; i++) {
            for (int j = left + 1; j < right; j++) {
                char c = img[i].charAt(j);
                if (c == '#') {
                    black++;
                } else {
                    white++;
                }
            }
        }
        return low * (black + white) <= black * 100 && black * 100 < high * (black + white);
    }

}
