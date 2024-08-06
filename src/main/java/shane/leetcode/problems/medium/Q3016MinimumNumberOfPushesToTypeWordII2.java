package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime65msBeats24.42%
 */
public class Q3016MinimumNumberOfPushesToTypeWordII2 {

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
        AtomicInteger index = new AtomicInteger(0);
        AtomicInteger answer = new AtomicInteger(0);
        cnt.entrySet()
                .stream()
                .sorted(Comparator.comparingInt(e -> -e.getValue()))
                .forEach(e -> {
                    int i = index.getAndIncrement();
                    int push = i / 8 + 1;
                    answer.addAndGet(push * e.getValue());
                });
        return answer.get();
    }

}
