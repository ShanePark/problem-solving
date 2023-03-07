package shane.programmers.lv1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class 바탕화면_정리 {

    @Test
    public void test() {
        assertThat(solution(new String[]{".#...", "..#..", "...#."})).containsExactly(0, 1, 3, 4);
        assertThat(solution(new String[]{"..........", ".....#....", "......##..", "...##.....", "....#....."})).containsExactly(1, 3, 5, 8);
        assertThat(solution(new String[]{".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."})).containsExactly(0, 0, 7, 9);
        assertThat(solution(new String[]{"..", "#."})).containsExactly(1, 0, 2, 1);
    }

    public int[] solution(String[] wallpaper) {
        int minY = Integer.MAX_VALUE, minX = Integer.MAX_VALUE;
        int maxY = 0, maxX = 0;
        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[0].length(); j++) {
                if ('#' == wallpaper[i].charAt(j)) {
                    minY = Math.min(minY, i);
                    maxY = Math.max(maxY, i);
                    minX = Math.min(minX, j);
                    maxX = Math.max(maxX, j);
                }
            }
        }
        return new int[]{minY, minX, maxY + 1, maxX + 1};
    }

}
