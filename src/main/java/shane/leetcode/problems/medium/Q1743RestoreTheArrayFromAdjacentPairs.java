package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 96ms Beats 77.87%of users with Java
 * Memory Details 80.52MB Beats 97.13%of users with Java
 */
public class Q1743RestoreTheArrayFromAdjacentPairs {

    @Test
    public void test() {
        assertThat(restoreArray(Ps.intArray("[[2,1],[3,4],[3,2]]"))).containsExactly(1, 2, 3, 4);
        assertThat(restoreArray(Ps.intArray("[[4,-2],[1,4],[-3,1]]"))).containsExactly(-2, 4, 1, -3);
        assertThat(restoreArray(Ps.intArray("[[100000,-100000]]"))).containsExactly(100000, -100000);

    }

    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, Number> map = new HashMap<>();
        for (int[] pair : adjacentPairs) {
            Number n1 = map.get(pair[0]);
            if (n1 == null) {
                n1 = new Number(pair[0]);
                map.put(pair[0], n1);
            }
            Number n2 = map.get(pair[1]);
            if (n2 == null) {
                n2 = new Number(pair[1]);
                map.put(pair[1], n2);
            }
            n1.addAdjacent(n2);
        }

        Number head = map.values()
                .stream()
                .filter(n -> n.isHead)
                .findAny()
                .orElseThrow();

        List<Integer> answer = new ArrayList<>();

        while (head != null) {
            answer.add(head.number);
            head = head.nextHead();
        }
        return answer.stream().mapToInt(Integer::valueOf).toArray();
    }

    class Number {
        int number;
        boolean isHead = true;
        List<Number> adjacent = new ArrayList<>();

        public Number(int number) {
            this.number = number;
        }

        public void addAdjacent(Number n2) {
            this.adjacent.add(n2);
            n2.adjacent.add(this);
            this.calcIsHead();
            n2.calcIsHead();
        }

        private void calcIsHead() {
            if (this.adjacent.size() == 2)
                this.isHead = false;
        }

        public Number nextHead() {
            if (adjacent.isEmpty())
                return null;
            Number next = adjacent.get(0);
            next.removeAdjacent(this);
            return next;
        }

        private void removeAdjacent(Number number) {
            adjacent.remove(number);
        }

        @Override
        public String toString() {
            return "Number{" +
                    "number=" + number +
                    ", isHead=" + isHead +
                    '}';
        }
    }

}
