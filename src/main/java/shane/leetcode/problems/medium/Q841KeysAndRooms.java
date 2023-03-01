package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 3 ms, faster than 56.42% of Java online submissions for Keys and Rooms.
 * Memory Usage: 45.9 MB, less than 5.51% of Java online submissions for Keys and Rooms.
 */
public class Q841KeysAndRooms {

    @Test
    public void test() {
        assertThat(canVisitAllRooms(Ps.intList("[[1],[2],[3],[]]"))).isEqualTo(true);
        assertThat(canVisitAllRooms(Ps.intList("[[1,3],[3,0,1],[2],[0]]"))).isEqualTo(false);
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> set = new HashSet<>();
        set.add(0);
        set.addAll(rooms.get(0));
        Queue<Integer> q = new LinkedList<>();
        q.addAll(rooms.get(0));
        while (!q.isEmpty()) {
            Integer poll = q.poll();
            List<Integer> keys = rooms.get(poll);
            for (Integer key : keys) {
                if (set.add(key)) {
                    q.add(key);
                }
            }
        }
        return set.size() == rooms.size();
    }
}
