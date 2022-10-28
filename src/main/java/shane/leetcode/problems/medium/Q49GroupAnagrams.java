package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 44 ms, faster than 18.46% of Java online submissions for Group Anagrams.
 * Memory Usage: 61.5 MB, less than 14.12% of Java online submissions for Group Anagrams.
 */
public class Q49GroupAnagrams {

    @Test
    public void test() {
        assertThat(groupAnagrams(new String[]{"bdddddddddd", "bbbbbbbbbbc"})).containsExactlyInAnyOrder(
                List.of("bbbbbbbbbbc"),
                List.of("bdddddddddd")
        );
        assertThat(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}))
                .containsExactlyInAnyOrder(
                        List.of("bat"),
                        List.of("tan", "nat"),
                        List.of("eat", "tea", "ate")
                );
        assertThat(groupAnagrams(new String[]{"a"}))
                .containsExactlyInAnyOrder(
                        List.of("a")
                );
        assertThat(groupAnagrams(new String[]{""}))
                .containsExactlyInAnyOrder(
                        List.of("")
                );
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, List<String>> map = new HashMap<>();
        for (String str : strs) {
            Anagram anagram = new Anagram(str);
            int hash = anagram.hashCode();
            List<String> list = map.getOrDefault(hash, new ArrayList<>());
            list.add(str);
            map.put(hash, list);
        }
        return map.values().stream().collect(Collectors.toList());
    }

    class Anagram {
        int[] arr = new int[26];

        Anagram(String str) {
            for (int i = 0; i < str.length(); i++) {
                arr[str.charAt(i) - 'a']++;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Anagram)) return false;
            Anagram anagram = (Anagram) o;
            return Arrays.equals(arr, anagram.arr);
        }

        @Override
        public int hashCode() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append(arr[i]).append(" ");
            }
            return sb.toString().hashCode();
        }
    }
}
