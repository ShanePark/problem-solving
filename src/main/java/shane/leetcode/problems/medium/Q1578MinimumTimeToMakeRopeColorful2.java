package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 20ms Beats 10.28%of users with Java
 * Memory Details 62.05MB Beats 10.03%of users with Java
 */
public class Q1578MinimumTimeToMakeRopeColorful2 {

    @Test
    public void test() {
        assertThat(minCost("abaac", new int[]{1, 2, 3, 4, 5})).isEqualTo(3);
        assertThat(minCost("abc", new int[]{1, 2, 3})).isEqualTo(0);
        assertThat(minCost("aabaa", new int[]{1, 2, 3, 4, 1})).isEqualTo(2);
    }

    public int minCost(String colors, int[] neededTime) {
        Queue<Balloon> q = new LinkedList<>();
        final int LENGTH = colors.length();
        for (int i = 0; i < LENGTH; i++) {
            char color = colors.charAt(i);
            int cost = neededTime[i];
            Balloon balloon = new Balloon(color, cost);
            q.offer(balloon);
        }
        Balloon before = q.poll();
        int total = 0;
        while (!q.isEmpty()) {
            Balloon cur = q.poll();
            if (!before.isSameColor(cur)) {
                before = cur;
                continue;
            }
            Balloon cheaper = getCheaper(before, cur);
            Balloon expensive = cheaper == before ? cur : before;
            total += cheaper.cost;
            before = expensive;
        }

        return total;
    }

    private Balloon getCheaper(Balloon before, Balloon cur) {
        if (before.cost < cur.cost) {
            return before;
        }
        return cur;
    }

    class Balloon {
        char color;
        int cost;

        public Balloon(char color, int cost) {
            this.color = color;
            this.cost = cost;
        }

        public boolean isSameColor(Balloon cur) {
            return this.color == cur.color;
        }
    }

}
