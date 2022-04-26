package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1941CheckIfAllCharactersHaveEqualNumberOfOccurrences {

    @Test
    public void test() {
        assertThat(areOccurrencesEqual("abacbc")).isTrue();
        assertThat(areOccurrencesEqual("aaabb")).isFalse();
    }

    public boolean areOccurrencesEqual(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.merge(s.charAt(i), 1, Integer::sum);
        }

        int n = map.get(s.charAt(0));
        for (Integer value : map.values()) {
            if(n != value)
                return false;
        }
        return true;
    }
}
