package shane.leetcode.problems.medium;

import com.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
@SuppressWarnings("ALL")
public class Q1202SmallestStringWithSwaps3 {

    @Test
    public void test() {
        assertThat(smallestStringWithSwaps("otilzqqoj", Ps.intList("[[2,3],[7,3],[3,8],[1,7],[1,0],[0,4],[0,6],[3,4],[2,5]]"))).isEqualTo("ijlooqqtz");
        assertThat(smallestStringWithSwaps("dcab", Ps.intList("[[0,3],[1,2],[0,2]]"))).isEqualTo("abcd");
        assertThat(smallestStringWithSwaps("dcab", Ps.intList("[[0,3],[1,2]]"))).isEqualTo("bacd");
        assertThat(smallestStringWithSwaps("cba", Ps.intList("[[0,1],[1,2]]"))).isEqualTo("abc");
        assertThat(smallestStringWithSwaps("dcab", Collections.EMPTY_LIST)).isEqualTo("dcab");

    }

    String str;

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int id = 0;
        str = s;

        Map<Integer, Group> map = new HashMap<>();
        Set<Group> groups = new HashSet<>();

        for (List<Integer> pair : pairs) {
            Group group1 = map.get(pair.get(0));
            Group group2 = map.get(pair.get(1));
            Group group = null;
            if (group1 == null && group2 == null) {
                group = new Group(id++);
                groups.add(group);
            } else if (group1 == null) {
                group = group2;
            } else if (group2 == null || group1.equals(group2)) {
                group = group1;
            } else {
                for (Integer i : group2.set) {
                    map.put(i, group1);
                }
                group1.merge(group2);
                groups.remove(group2);
                group = group1;
            }

            group.add(pair.get(0));
            group.add(pair.get(1));
            map.put(pair.get(0), group);
            map.put(pair.get(1), group);
        }

        StringBuffer sb = new StringBuffer(s);
        for (Group group : groups) {
            List<Integer> indexes = group.set.stream().sorted().collect(Collectors.toList());
            for (Integer i : indexes) {
                for (int j = 0; j < 26; j++) {
                    if (group.chars[j] > 0) {
                        group.chars[j]--;
                        sb.setCharAt(i, (char) ('a' + j));
                        break;
                    }
                }
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
        int[] chars = new int[26];

        public void merge(Group g) {
            set.addAll(g.set);
            for (int i = 0; i < 26; i++) {
                chars[i] += g.chars[i];
            }
            g.set.clear();
            g.chars = null;
        }

        public void add(int i) {
            if(set.add(i))
                chars[str.charAt(i) - 'a']++;
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

        @Override
        public String toString() {
            return "Group{" +
                    "id=" + id +
                    ", set=" + set +
                    ", chars=" + Arrays.toString(chars) +
                    '}';
        }
    }
}
