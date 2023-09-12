package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 43ms Beats 30.41%of users with Java
 * Memory Details 44.87MB Beats 13.38%of users with Java
 */
public class Q1647MinimumDeletionsToMakeCharacterFrequenciesUnique2 {

    @Test
    public void test() {
        assertThat(minDeletions("aab")).isEqualTo(0);
        assertThat(minDeletions("aaabbbcc")).isEqualTo(2);
        assertThat(minDeletions("ceabaacb")).isEqualTo(2);
    }

    public int minDeletions(String s) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            countMap.merge(c, 1, Integer::sum);
        }
        Set<Integer> set = new HashSet<>();
        int answer = 0;
        for (Integer n : countMap.values()) {
            while (n != 0 && !set.add(n--)) {
                answer++;
            }
        }
        return answer;
    }

}
