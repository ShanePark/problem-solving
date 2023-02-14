package shane.leetcode.problems.medium;

import com.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 3 ms Beats 57.13%
 * Memory 45.2 MB Beats 17.34%
 */
public class Q841KeysAndRooms2 {

    @Test
    public void test() {
        assertThat(canVisitAllRooms(Ps.intList("[[1],[2],[3],[]]"))).isEqualTo(true);
        assertThat(canVisitAllRooms(Ps.intList("[[1,3],[3,0,1],[2],[0]]"))).isEqualTo(false);
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> set = new HashSet<>();
        set.add(0);
        for (Integer key : rooms.get(0)) {
            addKeys(rooms, key, set);
        }
        return set.size() == rooms.size();
    }

    private void addKeys(List<List<Integer>> rooms, Integer key, Set<Integer> set) {
        if (set.add(key)) {
            for (Integer next : rooms.get(key)) {
                addKeys(rooms, next, set);
            }
        }
    }
}
