package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 24 ms Beats 22.71%
 * Memory 53.6 MB Beats 8.21%
 */
public class Q909SnakesAndLadders {

    @Test
    public void test() {
        assertThat(snakesAndLadders(Ps.intArray("[[-1,-1,19,10,-1],[2,-1,-1,6,-1],[-1,17,-1,19,-1],[25,-1,20,-1,-1],[-1,-1,-1,-1,15]]")))
                .isEqualTo(2);
        assertThat(snakesAndLadders(Ps.intArray("[[-1,1,2,-1],[2,13,15,-1],[-1,10,-1,-1],[-1,6,2,8]]")))
                .isEqualTo(2);
        assertThat(snakesAndLadders(Ps.intArray("[[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,35,-1,-1,13,-1],[-1,-1,-1,-1,-1,-1],[-1,15,-1,-1,-1,-1]]")))
                .isEqualTo(4);
        assertThat(snakesAndLadders(Ps.intArray("[[-1,-1],[-1,3]]")))
                .isEqualTo(1);
    }

    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Set<Integer> visited = new HashSet<>();
        Queue<Status> q = new LinkedList<>();
        q.offer(new Status(1));
        int move = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Status poll = q.poll();
                if (poll.cur == n * n)
                    return move;
                for (Status next : poll.moves(board)) {
                    if (visited.add(next.cur)) {
                        q.offer(next);
                    }
                }
            }
            move++;
        }
        return -1;
    }

    class Status {
        int cur;

        public Status(int cur) {
            this.cur = cur;
        }

        public List<Status> moves(int[][] board) {
            List<Status> answer = new ArrayList<>();
            int n = board.length;
            for (int i = 1; i <= 6 && cur + i <= n * n; i++) {
                int next = findNext(board, cur + i);
                answer.add(new Status(next));
            }
            return answer;
        }

        private int findNext(int[][] board, int i) {
            int n = board.length;
            int y = n - 1 - (i - 1) / n;
            int x = (i - 1) % n;
            if ((n - y) % 2 == 0) {
                x = n - 1 - x;
            }
            int val = board[y][x];
            if (val == -1)
                return i;
            return val;
        }

        @Override
        public String toString() {
            return "Status{" +
                    "cur=" + cur +
                    '}';
        }
    }

}
