package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime21msBeats43.26%
 */
public class Q567PermutationInString {

    @Test
    public void test() {
        assertThat(checkInclusion("ab", "eidbaooo")).isTrue();
        assertThat(checkInclusion("ab", "eidboaoo")).isFalse();
        assertThat(checkInclusion("ab", "a")).isFalse();
    }

    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() >s2.length()){
            return false;
        }
        Map<Character, Integer> cnt = new HashMap<>();
        for (char c : s1.toCharArray()) {
            cnt.merge(c, 1, Integer::sum);
        }
        final int LENGTH = s1.length();
        for (int i = 0; i < LENGTH; i++) {
            char c = s2.charAt(i);
            cnt.merge(c, -1, Integer::sum);
            if (cnt.get(c) == 0) {
                cnt.remove(c);
            }
        }
        if (cnt.isEmpty())
            return true;
        for (int i = LENGTH; i < s2.length(); i++) {
            char exclude = s2.charAt(i - LENGTH);
            cnt.merge(exclude, 1, Integer::sum);
            if (cnt.get(exclude) == 0) {
                cnt.remove(exclude);
            }
            char c = s2.charAt(i);
            cnt.merge(c, -1, Integer::sum);
            if (cnt.get(c) == 0) {
                cnt.remove(c);
            }
            if (cnt.isEmpty()) {
                return true;
            }
        }
        return false;
    }

}
