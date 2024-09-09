package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import io.github.shanepark.leetcode.ListNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime12msBeats11.11%
 */
public class Q2326SpiralMatrixIV2 {

    @Test
    public void test() {
        assertThat(spiralMatrix(3, 5, ListNode.of(3, 0, 2, 6, 8, 1, 7, 9, 4, 2, 5, 5, 0)))
                .isDeepEqualTo(Ps.intArray("[[3,0,2,6,8],[5,0,-1,-1,1],[5,2,4,9,7]]"));
    }

    @Test
    public void test2() {
        assertThat(spiralMatrix(1, 4, ListNode.of(0, 1, 2)))
                .isDeepEqualTo(Ps.intArray("[[0,1,2,-1]]"));
    }

    @Test
    public void test3() {
        assertThat(spiralMatrix(1, 4, ListNode.of(0, 1, 2, 3, 4, 5)))
                .isDeepEqualTo(Ps.intArray("[[0,1,2,3]]"));
    }

    int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] answer = new int[m][n];
        for (int[] ints : answer) {
            Arrays.fill(ints, -1);
        }

        int y = 0;
        int x = 0;
        int curDir = 0;
        answer[y][x] = head.val;
        head = head.next;
        int index = 1;

        while (head != null && index < m * n) {
            int nextY = y + DIRS[curDir][0];
            int nextX = x + DIRS[curDir][1];
            if (nextY < 0 || nextX < 0 || nextY == m || nextX == n || answer[nextY][nextX] >= 0) {
                curDir = (curDir + 1) % 4;
                continue;
            }
            y = nextY;
            x = nextX;
            answer[y][x] = head.val;
            head = head.next;
            index++;
        }

        return answer;
    }

}
