package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1298MaximumCandiesYouCanGetFromBoxes {

    @Test
    public void test() {
        assertThat(maxCandies(new int[]{1, 0, 1, 0}, new int[]{7, 5, 4, 100}, Ps.intArray("[[],[],[1],[]]"), Ps.intArray("[[1,2],[3],[],[]]"), new int[]{0}))
                .isEqualTo(16);
        assertThat(maxCandies(new int[]{1, 0, 0, 0, 0, 0}, new int[]{1, 1, 1, 1, 1, 1}, Ps.intArray("[[1,2,3,4,5],[],[],[],[],[]]"), Ps.intArray("[[1,2,3,4,5],[],[],[],[],[]]"), new int[]{0}));
    }

    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        boolean[] hasBox = new boolean[status.length];
        boolean[] used = new boolean[status.length];

        Queue<Integer> q = new LinkedList<>();
        int ans = 0;
        for (int box : initialBoxes) {
            hasBox[box] = true;
            if (status[box] == 1) {
                q.offer(box);
                used[box] = true;
                ans += candies[box];
            }
        }

        while (!q.isEmpty()) {
            int bigBox = q.poll();
            for (int key : keys[bigBox]) {
                status[key] = 1;
                if (!used[key] && hasBox[key]) {
                    q.offer(key);
                    used[key] = true;
                    ans += candies[key];
                }
            }
            for (int box : containedBoxes[bigBox]) {
                hasBox[box] = true;
                if (!used[box] && status[box] == 1) {
                    q.offer(box);
                    used[box] = true;
                    ans += candies[box];
                }
            }
        }
        return ans;
    }

}
