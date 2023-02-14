package shane.leetcode.problems.medium;

import com.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("ALL")
public class Q1202SmallestStringWithSwaps4 {

    @Test
    public void test() {
        assertThat(smallestStringWithSwaps("otilzqqoj", Ps.intList("[[2,3],[7,3],[3,8],[1,7],[1,0],[0,4],[0,6],[3,4],[2,5]]"))).isEqualTo("ijlooqqtz");
        assertThat(smallestStringWithSwaps("dcab", Ps.intList("[[0,3],[1,2],[0,2]]"))).isEqualTo("abcd");
        assertThat(smallestStringWithSwaps("dcab", Ps.intList("[[0,3],[1,2]]"))).isEqualTo("bacd");
        assertThat(smallestStringWithSwaps("cba", Ps.intList("[[0,1],[1,2]]"))).isEqualTo("abc");
        assertThat(smallestStringWithSwaps("dcab", Collections.EMPTY_LIST)).isEqualTo("dcab");
        assertThat(smallestStringWithSwaps("judyyek", Ps.intList("[[3,3],[3,0],[5,1],[3,1],[3,4],[3,5]]"))).isEqualTo("ejduyyk");

    }

    String str;

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {

        if (pairs.isEmpty())
            return s;

        int id = 0;
        str = s;

        Map<Integer, Group> map = new HashMap<>();

        for (List<Integer> pair : pairs) {
            Group group1 = map.get(pair.get(0));
            Group group2 = map.get(pair.get(1));
            Group group = null;
            if (group1 == null && group2 == null) {
                group = new Group(id++);
            } else if (group1 == null) {
                group = group2;
            } else if (group2 == null || group1.equals(group2)) {
                group = group1;
            } else {
                for (Integer i : group2.set) {
                    map.put(i, group1);
                }
                group1.merge(group2);
                group = group1;
            }

            group.add(pair.get(0));
            group.add(pair.get(1));
            map.put(pair.get(0), group);
            map.put(pair.get(1), group);
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            Group group = map.get(i);
            if (group == null) {
                sb.append(s.charAt(i));
            } else {
                sb.append(group.chars.poll());
            }
        }
        return sb.toString();
    }

    class Group {
        public Group(int id) {
            this.id = id;
        }

        int id;
        Set<Integer> set = new HashSet<>();
        PriorityQueue<Character> chars = new PriorityQueue<>();

        public void merge(Group g) {
            set.addAll(g.set);
            g.set.clear();
            chars.addAll(g.chars);
            g.chars = null;
        }

        public void add(int i) {
            if (set.add(i))
                chars.offer(str.charAt(i));
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Group group = (Group) o;
            return id == group.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }
}
