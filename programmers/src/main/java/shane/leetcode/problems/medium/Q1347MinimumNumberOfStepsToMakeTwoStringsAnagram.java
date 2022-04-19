package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1347MinimumNumberOfStepsToMakeTwoStringsAnagram {

    @Test
    public void test() {
        assertThat(minSteps("bab", "aba")).isEqualTo(1);
        assertThat(minSteps("leetcode", "practice")).isEqualTo(5);
        assertThat(minSteps("anagram", "mangaar")).isEqualTo(0);
    }

    public int minSteps(String s, String t) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            arr[t.charAt(i) - 'a']--;
        }

        int cnt = 0;
        for (int i : arr) {
            if (i > 0)
                cnt += i;
        }

        return cnt;
    }

}
