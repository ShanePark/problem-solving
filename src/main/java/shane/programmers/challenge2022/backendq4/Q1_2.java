package shane.programmers.challenge2022.backendq4;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1_2 {

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

    @Test
    public void test3() {
        assertThat(solution(0, 30, new String[]{
                "#######....###..###.",
                "#.....#....#.#..#.#.",
                "#.....#....###..###.",
                "#.....#.............",
                "#..#########........",
                "#..#..#....#.....##.",
                "#######....#.....##.",
                "...#.......#........",
                "...#.......#........",
                "...#..##############",
                "...#..#....#.......#",
                "...#..#....#.......#",
                "...#########.......#",
                "......#............#",
                "......##############"
        })).isEqualTo(4);
    }

    public int solution(int low, int high, String[] img) {
        int cnt = 0;
        int height = img.length;
        int width = img[0].length();
        for (int left = 0; left < width; left++) {
            for (int top = 0; top < height; top++) {
                for (int right = left + 2; right < width; right++) {
                    for (int down = top + 2; down < height; down++) {
                        if ((right - left == down - top) && check(top, left, down, right, low, high, img)) {
                            cnt++;
                        }
                    }
                }
            }
        }
        return cnt;
    }

    private boolean check(int top, int left, int down, int right, int low, int high, String[] img) {
        for (int i = top; i <= down; i++) {
            if (img[i].charAt(right) != '#' || img[i].charAt(left) != '#')
                return false;
        }
        for (int j = left; j <= right; j++) {
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
        int total = black + white;

        return low * total <= black * 100 && black * 100 < high * total;
    }

}
