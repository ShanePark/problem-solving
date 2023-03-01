package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q1202SmallestStringWithSwaps {

    @Test
    public void test() {
        assertThat(smallestStringWithSwaps("dcab", Ps.intList("[[0,3],[1,2],[0,2]]"))).isEqualTo("abcd");
        assertThat(smallestStringWithSwaps("dcab", Ps.intList("[[0,3],[1,2]]"))).isEqualTo("bacd");
        assertThat(smallestStringWithSwaps("cba", Ps.intList("[[0,1],[1,2]]"))).isEqualTo("abc");
        assertThat(smallestStringWithSwaps("dcab", Collections.EMPTY_LIST)).isEqualTo("dcab");
    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        List<Set<Integer>> sets = new ArrayList<>();
        for (List<Integer> pair : pairs) {
            Set<Integer> group = null;
            for (Set<Integer> set : sets) {
                if (set.contains(pair.get(0)) || set.contains(pair.get(1))) {
                    if (group != null) {
                        group.addAll(set);
                        set.clear();
                    } else {
                        group = set;
                    }
                }
            }
            if (group == null) {
                group = new HashSet<>();
                sets.add(group);
            }
            group.add(pair.get(0));
            group.add(pair.get(1));
        }

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
