package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2092FindAllPeopleWithSecret {

    @Test
    public void test() {
        assertThat(findAllPeople(5, Ps.intArray("[[3,4,2],[1,2,1],[2,3,1]]"), 1)).containsExactlyInAnyOrder(0, 1, 2, 3, 4);
        assertThat(findAllPeople(6, Ps.intArray("[[1,2,5],[2,3,8],[1,5,10]]"), 1)).containsExactlyInAnyOrder(0, 1, 2, 3, 5);
        assertThat(findAllPeople(4, Ps.intArray("[[3,1,3],[1,2,2],[0,3,3]]"), 3)).containsExactlyInAnyOrder(0, 1, 3);
    }

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Set<Integer> hasSecret = new HashSet<>();

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(p0 -> p0[1]));
        pq.offer(new int[]{0, 0});
        pq.offer(new int[]{firstPerson, 0});

        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] meeting : meetings) {
            map.get(meeting[0]).add(new int[]{meeting[1], meeting[2]});
            map.get(meeting[1]).add(new int[]{meeting[0], meeting[2]});
        }

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            hasSecret.add(poll[0]);

            if (!map.containsKey(poll[0])) continue;

            for (int[] m : map.get(poll[0])) {
                if (m[1] < poll[1])
                    continue;
                pq.offer(new int[]{m[0], m[1]});
            }
            map.remove(poll[0]);
        }

        return new ArrayList<>(hasSecret);
    }

}
