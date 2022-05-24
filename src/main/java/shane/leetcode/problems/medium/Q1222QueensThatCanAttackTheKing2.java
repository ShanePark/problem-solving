package shane.leetcode.problems.medium;

import com.tistory.shanepark.STool;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("ALL")
public class Q1222QueensThatCanAttackTheKing2 {

    @Test
    public void test() {
        assertThat(queensAttacktheKing(STool.convertToIntArray("[[5,6],[7,7],[2,1],[0,7],[1,6],[5,1],[3,7],[0,3],[4,0],[1,2],[6,3],[5,0],[0,4],[2,2],[1,1],[6,4],[5,4],[0,0],[2,6],[4,5],[5,2],[1,4],[7,5],[2,3],[0,5],[4,2],[1,0],[2,7],[0,1],[4,6],[6,1],[0,6],[4,3],[1,7]]"), new int[]{3, 4}))
                .containsExactlyInAnyOrderElementsOf(STool.convertToIntList("[[2,3],[1,4],[1,6],[3,7],[4,3],[5,4],[4,5]]"));
    }

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        boolean[][] board = new boolean[8][8];
        for (int[] queen : queens) {
            board[queen[0]][queen[1]] = true;
        }

        List<List<Integer>> answer = new ArrayList<>();
        int[] dirs = {-1, 0, 1};
        for (int dy : dirs) {
            for (int dx : dirs) {
                if (dy == dx && dx == 0) {
                    continue;
                }
                int y = king[0];
                int x = king[1];
                while (x + dx >= 0 && x + dx < 8 && y + dy >= 0 && y + dy < 8) {
                    x += dx;
                    y += dy;
                    if (board[y][x]) {
                        answer.add(List.of(y, x));
                        break;
                    }
                }
            }
        }
        return answer;
    }
}
