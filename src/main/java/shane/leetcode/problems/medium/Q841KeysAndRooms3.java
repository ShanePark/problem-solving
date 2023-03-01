package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 2 ms Beats 70.49%
 * Memory 41.8 MB Beats 95.69%
 */
public class Q841KeysAndRooms3 {

    @Test
    public void test() {
        assertThat(canVisitAllRooms(Ps.intList("[[1],[],[0,3],[1]]"))).isEqualTo(false);
        assertThat(canVisitAllRooms(Ps.intList("[[1,3],[1,4],[2,3,4,1],[],[4,3,2]]"))).isEqualTo(true);
        assertThat(canVisitAllRooms(Ps.intList("[[1],[2],[3],[]]"))).isEqualTo(true);
        assertThat(canVisitAllRooms(Ps.intList("[[1,3],[3,0,1],[2],[0]]"))).isEqualTo(false);
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> set = new HashSet(Collections.singletonList(0));
        Queue<Integer> q = new LinkedList<>(Collections.singletonList(0));

        while (!q.isEmpty()) {
            for (Integer key : rooms.get(q.poll())) {
                if (set.add(key)) {
                    q.add(key);
                }
            }
        }
        return set.size() == rooms.size();
    }
}
