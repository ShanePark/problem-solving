package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 16 ms, faster than 17.88% of Java online submissions for Top K Frequent Words.
 * Memory Usage: 45.5 MB, less than 24.62% of Java online submissions for Top K Frequent Words.
 */
public class Q692TopKFrequentWords {

    @Test
    public void test() {
        assertThat(topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2))
                .containsExactlyInAnyOrder("i", "love");
        assertThat(topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4))
                .containsExactlyInAnyOrder("the", "is", "sunny", "day");
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.merge(word, 1, Integer::sum);
        }
        return map.entrySet().stream()
                .sorted((a, b) -> {
                    if (a.getValue() == b.getValue()) {
                        return a.getKey().compareTo(b.getKey());
                    }
                    return Integer.compare(b.getValue(), a.getValue());
                })
                .limit(k)
                .map(e -> e.getKey())
                .collect(Collectors.toList());
    }

}
