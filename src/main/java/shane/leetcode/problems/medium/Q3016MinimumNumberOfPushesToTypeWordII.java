package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 64 ms Beats 38.21% of users with Java
 */
public class Q3016MinimumNumberOfPushesToTypeWordII {

    @Test
    public void test() {
        assertThat(minimumPushes("abcde")).isEqualTo(5);
        assertThat(minimumPushes("xyzxyzxyzxyz")).isEqualTo(12);
        assertThat(minimumPushes("aabbccddeeffgghhiiiiii")).isEqualTo(24);
    }

    public int minimumPushes(String word) {
        Map<Character, Integer> cnt = new HashMap<>();
        for (char c : word.toCharArray()) {
            cnt.merge(c, 1, Integer::sum);
        }
        List<Integer> counts = cnt.values().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        int size = counts.size();
        int sum = 0;
        for (int i = 0; i < size; i++) {
            Integer count = counts.get(i);
            sum += count * (i / 8 + 1);
        }
        return sum;
    }

}
