package shane.leetcode.problems.medium;

import com.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q1202SmallestStringWithSwaps2 {

    @Test
    public void test() {
        assertThat(smallestStringWithSwaps("otilzqqoj", Ps.intList("[[2,3],[7,3],[3,8],[1,7],[1,0],[0,4],[0,6],[3,4],[2,5]]")))
                .isEqualTo("ijlooqqtz");
        assertThat(smallestStringWithSwaps("dcab", Ps.intList("[[0,3],[1,2],[0,2]]"))).isEqualTo("abcd");
        assertThat(smallestStringWithSwaps("dcab", Ps.intList("[[0,3],[1,2]]"))).isEqualTo("bacd");
        assertThat(smallestStringWithSwaps("cba", Ps.intList("[[0,1],[1,2]]"))).isEqualTo("abc");
        assertThat(smallestStringWithSwaps("dcab", Collections.EMPTY_LIST)).isEqualTo("dcab");

    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {

        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (List<Integer> pair : pairs) {
            Set<Integer> group1 = map.get(pair.get(0));
            Set<Integer> group2 = map.get(pair.get(1));
            Set<Integer> group = null;
            if (group1 == null && group2 == null) {
                group = new HashSet<>();
            } else if (group1 == null) {
                group = group2;
            } else if (group2 == null) {
                group = group1;
            } else {
                group1.addAll(group2);
                for (Integer i : group2) {
                    map.put(i, group1);
                }
                group = group1;
            }

            group.add(pair.get(0));
            group.add(pair.get(1));
            map.put(pair.get(0), group);
            map.put(pair.get(1), group);
        }

        List<Set<Integer>> sets = map.values().stream().distinct().collect(Collectors.toList());

        StringBuffer sb = new StringBuffer(s);
        for (Set<Integer> set : sets) {
            PriorityQueue<Character> chars = new PriorityQueue<>();
            PriorityQueue<Integer> nums = new PriorityQueue<>();
            for (Integer i : set) {
                chars.offer(s.charAt(i));
                nums.offer(i);
            }
            while (!nums.isEmpty()) {
                sb.setCharAt(nums.poll(), chars.poll());
            }

        }
        return sb.toString();
    }
}
