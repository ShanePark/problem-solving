package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 2413 ms Beats 5%
 * Memory 144.5 MB Beats 8.81%
 */
public class Q212WordSearchII {

    @Test
    public void test() {
        assertThat(findWords(new char[][]{
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        }, new String[]{"oath", "pea", "eat", "rain"})).containsExactlyInAnyOrder("oath", "eat");

        assertThat(findWords(new char[][]{
                {'a', 'b'},
                {'c', 'd'}
        }, new String[]{"abcb"})).isEmpty();

    }

    @Test
    public void test2() {
        assertThat(findWords(new char[][]{{'a', 'a'},}, new String[]{"aaa"})).isEmpty();
    }

    final int[][] DIRS = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public List<String> findWords(char[][] board, String[] words) {
        Set<String> set = Arrays.stream(words).collect(Collectors.toSet());
        Set<String> answer = new HashSet<>();
        final int HEIGHT = board.length;
        final int WIDTH = board[0].length;
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                boolean[][] visited = new boolean[HEIGHT][WIDTH];
                visited[i][j] = true;
                travel(board, i, j, new StringBuilder(), set, answer, visited);
            }
        }
        return new ArrayList<>(answer);
    }

    private void travel(char[][] board, int i, int j, StringBuilder sb, Set<String> set, Set<String> answer, boolean[][] visited) {
        if (sb.length() == 10)
            return;
        char c = board[i][j];
        sb.append(c);
        if (set.contains(sb.toString())) {
            answer.add(sb.toString());
        }

        for (int[] dir : DIRS) {
            int y = i + dir[0];
            int x = j + dir[1];

            if (y < 0 || x < 0 || y == board.length || x == board[0].length || visited[y][x])
                continue;
            visited[y][x] = true;
            travel(board, y, x, sb, set, answer, visited);
            visited[y][x] = false;

        }

        sb.deleteCharAt(sb.length() - 1);

    }

}
