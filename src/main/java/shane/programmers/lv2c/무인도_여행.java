package shane.programmers.lv2c;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class 무인도_여행 {

    @Test
    public void test() {
        assertThat(solution(new String[]{"X591X", "X1X5X", "X231X", "1XXX1"})).containsExactly(1, 1, 27);
        assertThat(solution(new String[]{"XXX", "XXX", "XXX"})).containsExactly(-1);
    }

    public int[] solution(String[] maps) {
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        List<Integer> days = new ArrayList<>();
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                if (visited[i][j]) continue;
                int day = visitDfs(i, j, visited, maps);
                if (day > 0) days.add(day);
            }
        }
        if (days.isEmpty()) return new int[]{-1};
        return days.stream().sorted().mapToInt(Integer::valueOf).toArray();
    }

    private int visitDfs(int i, int j, boolean[][] visited, String[] maps) {
        visited[i][j] = true;
        char c = maps[i].charAt(j);
        if (c == 'X') return 0;

        int sum = c - '0';
        if (0 < i && !visited[i - 1][j]) {// UP
            sum += visitDfs(i - 1, j, visited, maps);
        }
        if (i < visited.length - 1 && !visited[i + 1][j]) {// DOWN
            sum += visitDfs(i + 1, j, visited, maps);
        }
        if (0 < j && !visited[i][j - 1]) {// LEFT
            sum += visitDfs(i, j - 1, visited, maps);
        }
        if (j < visited[0].length - 1 && !visited[i][j + 1]) {// RIGHT
            sum += visitDfs(i, j + 1, visited, maps);
        }
        return sum;
    }
}
