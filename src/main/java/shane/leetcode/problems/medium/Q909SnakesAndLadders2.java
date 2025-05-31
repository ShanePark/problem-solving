package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 10
 * ms
 * Beats
 * 27.74%
 */
public class Q909SnakesAndLadders2 {

    @Test
    public void test() {
        assertThat(snakesAndLadders(Ps.intArray("[[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,35,-1,-1,13,-1],[-1,-1,-1,-1,-1,-1],[-1,15,-1,-1,-1,-1]]")))
                .isEqualTo(4);
        assertThat(snakesAndLadders(Ps.intArray("[[-1,-1],[-1,3]]")))
                .isEqualTo(1);
    }

    public int snakesAndLadders(int[][] board) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        int step = 0;
        int target = board.length * board.length;
        Map<Integer, Integer> boardMap = boardMap(board);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int poll = q.poll();
                if (poll == target)
                    return step;
                for (int j = 1; j <= 6 && poll + j <= target; j++) {
                    int nextVal = boardMap.put(poll + j, -2);
                    if (nextVal == -2)
                        continue;
                    if (nextVal == -1)
                        nextVal = poll + j;
                    q.offer(nextVal);
                }
            }
            step++;
        }
        return -1;
    }

    private Map<Integer, Integer> boardMap(int[][] board) {
        int y = board.length - 1;
        int x = 0;
        int target = board.length * board.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int index = 1; index <= target; index++) {
            map.put(index, board[y][x]);
            if (((index - 1) / board.length) % 2 == 0) {
                if (x == board.length - 1) {
                    y--;
                    continue;
                }
                x++;
                continue;
            }
            if (x == 0) {
                y--;
                continue;
            }
            x--;
        }
        return map;
    }

}
