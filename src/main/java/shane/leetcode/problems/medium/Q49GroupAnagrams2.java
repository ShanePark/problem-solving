package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 17 ms Beats 20.97% of users with Java
 */
public class Q49GroupAnagrams2 {

    @Test
    public void test() {
        assertThat(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}))
                .containsExactlyInAnyOrder(
                        List.of("bat"),
                        List.of("tan", "nat"),
                        List.of("eat", "tea", "ate")
                );
        assertThat(groupAnagrams(new String[]{""}))
                .containsExactlyInAnyOrder(
                        List.of("")
                );
        assertThat(groupAnagrams(new String[]{"a"}))
                .containsExactlyInAnyOrder(
                        List.of("a")
                );
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> answer = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String str : strs) {
            String parsed = parse(str);
            Integer index = map.get(parsed);
            if (index == null) {
                index = answer.size();
                map.put(parsed, index);
                answer.add(new ArrayList<>());
            }
            answer.get(index).add(str);
        }
        return answer;
    }

    private String parse(String str) {
        int[] arr = new int[26];
        for (char c : str.toCharArray()) {
            arr[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i);
            sb.append(" ");
        }
        return sb.toString();
    }

}
