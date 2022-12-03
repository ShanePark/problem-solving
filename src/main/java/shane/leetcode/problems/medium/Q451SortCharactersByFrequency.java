package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 51 ms Beats 32.95%
 * Memory 54.6 MB Beats 32.89%
 */
public class Q451SortCharactersByFrequency {

    @Test
    public void test() {
        assertThat(frequencySort("tree")).isEqualTo("eert");
        assertThat(frequencySort("cccaaa")).isEqualTo("aaaccc");
        assertThat(frequencySort("Aabb")).isEqualTo("bbaA");
    }

    public String frequencySort(String s) {
        Map<Character, Integer> cnt = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            cnt.merge(c, 1, Integer::sum);
        }
        StringBuilder sb = new StringBuilder();
        cnt.entrySet().stream().sorted(Comparator.comparingInt(e -> -e.getValue()))
                .forEach(e -> {
                    for (int i = 0; i < e.getValue(); i++) {
                        sb.append(e.getKey());
                    }
                });
        return sb.toString();
    }

}
