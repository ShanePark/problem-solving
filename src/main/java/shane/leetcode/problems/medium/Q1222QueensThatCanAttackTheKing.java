package shane.leetcode.problems.medium;

import com.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1222QueensThatCanAttackTheKing {

    @Test
    public void test() {
        assertThat(queensAttacktheKing(Ps.intArray("[[5,6],[7,7],[2,1],[0,7],[1,6],[5,1],[3,7],[0,3],[4,0],[1,2],[6,3],[5,0],[0,4],[2,2],[1,1],[6,4],[5,4],[0,0],[2,6],[4,5],[5,2],[1,4],[7,5],[2,3],[0,5],[4,2],[1,0],[2,7],[0,1],[4,6],[6,1],[0,6],[4,3],[1,7]]"), new int[]{3, 4}))
                .containsExactlyInAnyOrderElementsOf(Ps.intList("[[2,3],[1,4],[1,6],[3,7],[4,3],[5,4],[4,5]]"));
    }

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        boolean[][] board = new boolean[8][8];
        for (int[] queen : queens) {
            board[queen[0]][queen[1]] = true;
        }
        List<int[]> ways8 = new ArrayList<>(List.of(new int[]{-1, 0}, new int[]{-1, 1}, new int[]{0, 1}, new int[]{1, 1}, new int[]{1, 0}, new int[]{1, -1}, new int[]{0, -1}, new int[]{-1, -1}));
        List<int[]> points = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            points.add(new int[]{king[0], king[1]});
        }

        List<List<Integer>> answer = new ArrayList<>();
        while (!ways8.isEmpty()) {
            for (int i = 0; i < ways8.size(); i++) {
                int[] point = points.get(i);
                int[] way = ways8.get(i);
                point[0] = point[0] + way[0];
                point[1] = point[1] + way[1];
                if (point[0] < 0 || point[0] >= 8 || point[1] < 0 || point[1] >= 8) {
                    ways8.remove(i);
                    points.remove(i);
                    i--;
                } else if (board[point[0]][point[1]] == true) {
                    answer.add(List.of(point[0], point[1]));
                    ways8.remove(i);
                    points.remove(i);
                    i--;
                }
            }
        }
        return answer;
    }
}
