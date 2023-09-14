package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 6ms Beats 70.35%of users with Java
 * Memory Details 44.32MB Beats 68.11%of users with Java
 */
public class Q332ReconstructItinerary {

    @Test
    public void test() {
        assertThat(findItinerary(Ps.strList("[[\"JFK\",\"SFO\"],[\"JFK\",\"ATL\"],[\"SFO\",\"ATL\"],[\"ATL\",\"JFK\"],[\"ATL\",\"SFO\"]]")))
                .isEqualTo(List.of("JFK", "ATL", "JFK", "SFO", "ATL", "SFO"));
        assertThat(findItinerary(Ps.strList("[[\"JFK\",\"KUL\"],[\"JFK\",\"NRT\"],[\"NRT\",\"JFK\"]]")))
                .isEqualTo(List.of("JFK", "NRT", "JFK", "KUL"));
        assertThat(findItinerary(Ps.strList("[[\"MUC\",\"LHR\"],[\"JFK\",\"MUC\"],[\"SFO\",\"SJC\"],[\"LHR\",\"SFO\"]]")))
                .isEqualTo(List.of("JFK", "MUC", "LHR", "SFO", "SJC"));
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> map = new HashMap<>();
        for (List<String> ticket : tickets) {
            String dep = ticket.get(0);
            String arr = ticket.get(1);
            List<String> fromDep = map.getOrDefault(dep, new ArrayList<>());
            fromDep.add(arr);
            map.put(dep, fromDep);
        }

        map.values().forEach(l -> Collections.sort(l));

        List<String> answer = new ArrayList<>();
        answer.add("JFK");
        travel(answer, map, "JFK", tickets.size() + 1);
        return answer;
    }

    private boolean travel(List<String> answer, Map<String, List<String>> map, String before, int length) {
        if (answer.size() == length)
            return true;
        List<String> list = map.get(before);
        if (list == null || list.isEmpty())
            return false;
        for (int i = 0; i < list.size(); i++) {
            String next = list.get(i);
            list.remove(i);
            answer.add(next);
            if (travel(answer, map, next, length)) {
                return true;
            }
            list.add(i, next);
            answer.remove(answer.size() - 1);
        }
        return false;
    }

}
