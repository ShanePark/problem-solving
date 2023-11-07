package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 53ms Beats 27.08%of users with Java
 * Memory Details 56.58MB Beats 19.79%of users with Java
 */
public class Q1921EliminateMaximumNumberOfMonsters {

    @Test
    public void test() {
        assertThat(eliminateMaximum(new int[]{1, 1, 2, 3}, new int[]{1, 1, 1, 1})).isEqualTo(1);
        assertThat(eliminateMaximum(new int[]{1, 3, 4}, new int[]{1, 1, 1})).isEqualTo(3);
        assertThat(eliminateMaximum(new int[]{3, 2, 4}, new int[]{5, 3, 2})).isEqualTo(1);
    }

    @Test
    public void test2() {
        assertThat(eliminateMaximum(new int[]{4, 2, 3}, new int[]{2, 1, 1})).isEqualTo(3);
    }

    public int eliminateMaximum(int[] dist, int[] speed) {
        List<Monster> monsters = new ArrayList<>();
        for (int i = 0; i < dist.length; i++) {
            int d = dist[i];
            int s = speed[i];
            Monster monster = new Monster(d, s);
            monsters.add(monster);
        }
        Collections.sort(monsters);
        for (int i = 1; i < dist.length; i++) {
            Monster before = monsters.get(i - 1);
            Monster cur = monsters.get(i);
            if (before.reachAt == cur.reachAt && cur.reachAt <= i) {
                return i;
            }
        }
        return dist.length;
    }

    class Monster implements Comparable<Monster> {
        int distance;
        int speed;
        int reachAt;

        @Override
        public String toString() {
            return "Monster{" +
                    "distance=" + distance +
                    ", speed=" + speed +
                    ", reachAt=" + reachAt +
                    '}';
        }

        public Monster(int distance, int speed) {
            this.distance = distance;
            this.speed = speed;
            this.reachAt = (int) Math.ceil((double) distance / speed);
        }

        @Override
        public int compareTo(Monster o) {
            if (this.reachAt < o.reachAt)
                return -1;
            if (this.reachAt == o.reachAt)
                return 0;
            return 1;
        }
    }

}
