package shane.leetcode.problems.medium;

import com.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("ALL")
public class Q1202SmallestStringWithSwaps5 {

    @Test
    public void test() {
        assertThat(smallestStringWithSwaps("otilzqqoj", Ps.intList("[[2,3],[7,3],[3,8],[1,7],[1,0],[0,4],[0,6],[3,4],[2,5]]"))).isEqualTo("ijlooqqtz");
        assertThat(smallestStringWithSwaps("dcab", Ps.intList("[[0,3],[1,2],[0,2]]"))).isEqualTo("abcd");
        assertThat(smallestStringWithSwaps("dcab", Ps.intList("[[0,3],[1,2]]"))).isEqualTo("bacd");
        assertThat(smallestStringWithSwaps("cba", Ps.intList("[[0,1],[1,2]]"))).isEqualTo("abc");
        assertThat(smallestStringWithSwaps("dcab", Collections.EMPTY_LIST)).isEqualTo("dcab");
        assertThat(smallestStringWithSwaps("judyyek", Ps.intList("[[3,3],[3,0],[5,1],[3,1],[3,4],[3,5]]"))).isEqualTo("ejduyyk");
    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        Map<Integer, Integer> groupMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            groupMap.put(i, i);
        }

        for (List<Integer> pair : pairs) {
            int group1 = findGroup(groupMap, pair.get(0));
            int group2 = findGroup(groupMap, pair.get(1));
            if (group1 < group2) {
                groupMap.put(group2, group1);
            } else {
                groupMap.put(group1, group2);
            }
        }

        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int group = findGroup(groupMap, i);
            map.putIfAbsent(group, new PriorityQueue<>());
            map.get(group).offer(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(map.get(findGroup(groupMap, i)).poll());
        }
        return sb.toString();

    }

    int findGroup(Map<Integer, Integer> groupMap, int i) {
        while (groupMap.get(i) != i) {
            groupMap.put(i, groupMap.get(i));
            i = groupMap.get(i);
        }
        return i;
    }

}
