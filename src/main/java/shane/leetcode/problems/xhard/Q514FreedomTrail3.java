package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 42 ms Beats 31.55% of users with Java
 */
public class Q514FreedomTrail3 {

    @Test
    public void test() {
        assertThat(findRotateSteps("godding", "gd")).isEqualTo(4);
        assertThat(findRotateSteps("godding", "godding")).isEqualTo(13);
        assertThat(findRotateSteps("aaaaa", "aaaaa")).isEqualTo(5);
    }

    @Test
    public void tle() {
        assertThat(findRotateSteps("fjghcgmfli", "hjgfjgmmighfcghgjlhifcgicgmgjihhffchglflgiclffhiggcicjmfmfghhffllifglggfjjgcmgjglcijfffmfflgijmcflmm")).isEqualTo(318);
    }

    public int findRotateSteps(String ring, String key) {
        int step = 0;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});

        boolean[][] visited = new boolean[key.length() + 1][ring.length()];
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] poll = q.poll();
                int index = poll[0];
                int dial = poll[1];

                if (index == key.length())
                    return step;

                char target = key.charAt(index);
                if (ring.charAt(dial) == target) {
                    q.offer(new int[]{index + 1, dial});
                }

                int leftDial = (ring.length() + dial - 1) % ring.length();
                if (!visited[index][leftDial]) {
                    visited[index][leftDial] = true;
                    q.offer(new int[]{index, leftDial});
                }

                int rightDial = (ring.length() + dial + 1) % ring.length();
                if (!visited[index][rightDial]) {
                    visited[index][rightDial] = true;
                    q.offer(new int[]{index, rightDial});
                }
            }
            step++;
        }

        return step;
    }

}
