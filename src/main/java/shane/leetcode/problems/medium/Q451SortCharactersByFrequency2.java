package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 18 ms Beats 44.57% of users with Java
 */
public class Q451SortCharactersByFrequency2 {

    @Test
    public void test() {
        assertThat(frequencySort("tree")).isEqualTo("eert");
        assertThat(frequencySort("cccaaa")).isEqualTo("aaaccc");
        assertThat(frequencySort("Aabb")).isEqualTo("bbaA");
    }

    public String frequencySort(String s) {
        Map<Character, Integer> cntMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            cntMap.merge(c, 1, Integer::sum);
        }
        return cntMap.entrySet()
                .stream().sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue())).map(e -> {
                    Character c = e.getKey();
                    int cnt = e.getValue();
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < cnt; i++) {
                        sb.append(c);
                    }
                    return sb.toString();
                }).collect(Collectors.joining());
    }

}
