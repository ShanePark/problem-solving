package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 124ms Beats 12.69%of users with Java
 * Memory Details 73.01MB Beats 37.31%of users with Java
 */
public class Q2251NumberOfFlowersInFullBloom {

    @Test
    public void test() {
        assertThat(fullBloomFlowers(Ps.intArray("[[19,37],[19,38],[19,35]]"), new int[]{6, 7, 21, 1, 13, 37, 5, 37, 46, 43})).containsExactly(0, 0, 3, 0, 0, 2, 0, 2, 0, 0);
        assertThat(fullBloomFlowers(Ps.intArray("[[1,6],[3,7],[9,12],[4,13]]"), new int[]{2, 3, 7, 11})).containsExactly(1, 2, 2, 2);
        assertThat(fullBloomFlowers(Ps.intArray("[[1,10],[3,3]]"), new int[]{3, 3, 2})).containsExactly(2, 2, 1);
    }

    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.index));
        for (int[] flower : flowers) {
            pq.offer(new Point(flower[0], 1));
            pq.offer(new Point(flower[1] + 1, -1));
        }
        List<Integer> peopleIndex = Arrays.stream(people)
                .distinct()
                .sorted()
                .boxed()
                .collect(Collectors.toList());
        Map<Integer, Integer> cntMap = new HashMap<>();

        int cur = 0;
        for (Integer person : peopleIndex) {
            while (!pq.isEmpty() && pq.peek().index <= person) {
                Point poll = pq.poll();
                cur += poll.change;
            }
            cntMap.put(person, cur);
        }
        int[] answer = new int[people.length];
        for (int i = 0; i < people.length; i++) {
            answer[i] = cntMap.get(people[i]);
        }
        return answer;
    }

    class Point {
        int index;
        int change;

        public Point(int index, int change) {
            this.index = index;
            this.change = change;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "index=" + index +
                    ", change=" + change +
                    '}';
        }
    }
}
