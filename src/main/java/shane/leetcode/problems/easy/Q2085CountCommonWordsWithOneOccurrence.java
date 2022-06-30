package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2085CountCommonWordsWithOneOccurrence {

    @Test
    public void test() {
        assertThat(countWords(new String[]{"leetcode", "is", "amazing", "as", "is"}, new String[]{"amazing", "leetcode", "is"})).isEqualTo(2);
        assertThat(countWords(new String[]{"a", "ab"}, new String[]{"a", "a", "a", "ab"})).isEqualTo(1);
    }

    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for (String s : words1) {
            map.merge(s, 1, Integer::sum);
        }
        for (String s : words2) {
            map2.merge(s, 1, Integer::sum);
        }
        int result = 0;
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if (e.getValue() == 1) {
                if (map2.getOrDefault(e.getKey(), 0) == 1) {
                    result++;
                }
            }
        }
        return result;
    }

}
