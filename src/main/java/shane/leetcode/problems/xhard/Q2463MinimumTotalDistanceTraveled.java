package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 16 / 40 testcases passed
 */
public class Q2463MinimumTotalDistanceTraveled {

    @Test
    public void test() {
        assertThat(minimumTotalDistance(List.of(0, 4, 6), Ps.intArray("[[2,2],[6,2]]"))).isEqualTo(4);
        assertThat(minimumTotalDistance(List.of(1, -1), Ps.intArray("[[-2,1],[2,1]]"))).isEqualTo(2);
    }

    @Test
    public void fail() {
        assertThat(minimumTotalDistance(List.of(9, 11), Ps.intArray("[[10,1],[7,1],[14,1]"))).isEqualTo(3);
    }

    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Set<Factory> factories = new HashSet<>();
        for (int[] ints : factory) {
            factories.add(new Factory(ints[0], ints[1]));
        }

        long answer = 0;
        for (Integer position : robot) {
            Factory f = factories.stream().min(Comparator.comparingLong(fac -> Math.abs(fac.position - position))).get();
            answer += Math.abs(f.repair(position));
            if (f.isEmpty()) {
                factories.remove(f);
            }
        }
        return answer;
    }

    static class Factory {
        final int position;
        int capacity;

        Factory(int position, int capacity) {
            this.position = position;
            this.capacity = capacity;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Factory)) return false;
            Factory factory = (Factory) o;
            return position == factory.position;
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(position);
        }

        public int repair(int robot) {
            capacity--;
            return Math.abs(robot - position);
        }

        public boolean isEmpty() {
            return capacity == 0;
        }
    }

}
