package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 883 ms Beats 38.10%
 * Memory 59.3 MB Beats 36.51%
 */
public class Q2306NamingACompany2 {

    @Test
    public void test() {
        assertThat(distinctNames(new String[]{"coffee", "donuts", "time", "toffee"})).isEqualTo(6);
        assertThat(distinctNames(new String[]{"lack", "back"})).isEqualTo(0);
    }

    public long distinctNames(String[] ideas) {
        Map<Character, Set<String>> map = new HashMap<>();
        for (String idea : ideas) {
            map.compute(idea.charAt(0), (k, v) -> {
                if (v == null)
                    v = new HashSet<>();
                v.add(idea.substring(1));
                return v;
            });
        }

        long answer = 0;
        for (Character head1 : map.keySet()) {
            for (Character head2 : map.keySet()) {
                if (head1 == head2) continue;
                long c1 = map.get(head1).stream()
                        .filter(str -> !map.get(head2).contains(str))
                        .count();
                long c2 = map.get(head2).stream()
                        .filter(str -> !map.get(head1).contains(str))
                        .count();
                answer += c1 * c2;
            }
        }

        return answer;
    }

}
