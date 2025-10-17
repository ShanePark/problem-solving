package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q3003MaximizeTheNumberOfPartitionsAfterOperations {

    @Test
    public void test() {
        assertThat(maxPartitionsAfterOperations("accca", 2)).isEqualTo(3);
        assertThat(maxPartitionsAfterOperations("aabaab", 3)).isEqualTo(1);
    }

    @Test
    public void tle() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            sb.append((char) ('a' + (i % 3)));
        }
        assertThat(maxPartitionsAfterOperations(sb.toString(), 2)).isEqualTo(5000);
    }

    public int maxPartitionsAfterOperations(String s, int k) {
        int best = countPartitions(s, k);
        for (int i = 0; i < s.length(); i++) {
            char original = s.charAt(i);
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == original) continue;
                StringBuilder sb = new StringBuilder(s);
                sb.setCharAt(i, c);
                best = Math.max(best, countPartitions(sb.toString(), k));
            }
        }
        return best;
    }

    int countPartitions(String s, int k) {
        int partitions = 0;
        Map<Character, Integer> cnt = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            cnt.merge(s.charAt(i), 1, Integer::sum);
            if (cnt.size() > k) {
                partitions++;
                cnt.clear();
                cnt.put(s.charAt(i), 1);
            }
        }
        return partitions + 1;
    }

}
