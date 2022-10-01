package shane.programmers.challenge2022.backendq3;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 채점 결과
 * 정확성: 95.0
 * 효율성: 0.0
 * 합계: 95.0 / 100.0
 * 테스트 20 〉 실패 (런타임 에러)
 */
@SuppressWarnings("ALL")
public class Q2 {

    @Test
    public void test() {
        assertThat(solution(new String[]{"."})).isEqualTo(0);
        assertThat(solution(new String[]{"..", "..", "..", ".."})).isEqualTo(0);
        assertThat(solution(new String[]{"AA", "AA", "AA", "AA"})).isEqualTo(8);
        assertThat(solution(new String[]{"AABCA.QA", "AABC..QX", "BBBC.Y..", ".A...T.A", "....EE..", ".M.XXEXQ", "KL.TBBBQ"}))
                .isEqualTo(15);
        assertThat(solution(new String[]{"XY..", "YX..", "..YX", ".AXY"}))
                .isEqualTo(5);
    }

    public int solution(String[] maps) {
        final int HEIGHT = maps.length;
        final int WIDTH = maps[0].length();
        int[] sizes = new int[26];

        char[][] board = new char[HEIGHT][WIDTH];
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                board[i][j] = maps[i].charAt(j);
            }
        }

        Map<Integer, District> districtMap = new HashMap<>();
        int districtCnt = 0;
        boolean[][] visited = new boolean[HEIGHT][WIDTH];
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (board[i][j] != '.' && !visited[i][j]) {
                    District district = new District((districtCnt));
                    districtMap.put(districtCnt++, district);
                    visitNeighboursDfs(i, j, district, board, visited, sizes);
                }
            }
        }

        districtMap.values().stream()
                .forEach(d -> d.fight(board, sizes));

        return Arrays.stream(sizes).max().getAsInt();

    }

    private void visitNeighboursDfs(int i, int j, District district, char[][] board, boolean[][] visited, int[] sizes) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] == '.') {
            return;
        }
        visited[i][j] = true;
        district.checkout(i, j, board, sizes);

        visitNeighboursDfs(i - 1, j, district, board, visited, sizes);
        visitNeighboursDfs(i + 1, j, district, board, visited, sizes);
        visitNeighboursDfs(i, j - 1, district, board, visited, sizes);
        visitNeighboursDfs(i, j + 1, district, board, visited, sizes);
    }

    class District {
        int index;
        List<int[]> points = new ArrayList<>();
        Map<Character, Integer> countryCounts = new HashMap<>();
        int maxPower = 0;

        public District(int index) {
            this.index = index;
        }

        public void checkout(int i, int j, char[][] board, int[] sizes) {
            points.add(new int[]{i, j});
            char country = board[i][j];
            Integer coutryPower = countryCounts.merge(country, 1, Integer::sum);
            maxPower = Math.max(maxPower, coutryPower);
            sizes[country - 'A']++;
        }

        @Override
        public String toString() {
            return "District{" +
                    "index=" + index +
                    ", countryCounts=" + countryCounts +
                    '}';
        }

        public void fight(char[][] board, int[] sizes) {
            Character bestCountry = countryCounts.entrySet().stream()
                    .filter(e -> e.getValue() == maxPower)
                    .sorted((o1, o2) -> Character.compare(o2.getKey(), o1.getKey()))
                    .findFirst()
                    .get()
                    .getKey();

            for (int[] point : points) {
                char country = board[point[0]][point[1]];
                if (countryCounts.get(country) < maxPower) {
                    sizes[bestCountry - 'A']++;
                    sizes[country - 'A']--;
                }
            }
        }
    }

}
