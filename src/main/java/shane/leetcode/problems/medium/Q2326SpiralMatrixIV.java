package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import io.github.shanepark.leetcode.ListNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2326SpiralMatrixIV {

    @Test
    public void test() {
        assertThat(spiralMatrix(3, 5, ListNode.of(3, 0, 2, 6, 8, 1, 7, 9, 4, 2, 5, 5, 0)))
                .isDeepEqualTo(Ps.intArray("[[3,0,2,6,8],[5,0,-1,-1,1],[5,2,4,9,7]]"));
        assertThat(spiralMatrix(1, 4, ListNode.of(0, 1, 2)))
                .isDeepEqualTo(Ps.intArray("[[0,1,2,-1]]"));
        assertThat(spiralMatrix(1, 4, ListNode.of(0, 1, 2, 3, 4, 5)))
                .isDeepEqualTo(Ps.intArray("[[0,1,2,3]]"));
    }

    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] answer = new int[m][n];
        for (int[] ints : answer) {
            Arrays.fill(ints, -1);
        }

        int y = 0;
        int x = 0;
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int curDir = 0;
        int cnt = 0;
        while (head != null) {
            answer[y][x] = head.val;

            if (++cnt == m * n) {
                return answer;
            }

            int[] dir = dirs[curDir];
            int nextY = y + dir[0];
            int nextX = x + dir[1];
            if (nextY < 0 || nextY >= m || nextX < 0 || nextX >= n || answer[nextY][nextX] != -1) {
                curDir = (curDir + 1) % 4;
                nextY = y + dirs[curDir][0];
                nextX = x + dirs[curDir][1];
            }
            y = nextY;
            x = nextX;
            head = head.next;
        }
        return answer;
    }
}
