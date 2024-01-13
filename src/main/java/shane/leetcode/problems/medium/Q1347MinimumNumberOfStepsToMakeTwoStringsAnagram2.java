package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 8 ms Beats 76.51% of users with Java
 * Memory 45.30 MB Beats 18.05% of users with Java
 */
public class Q1347MinimumNumberOfStepsToMakeTwoStringsAnagram2 {

    @Test
    public void test() {
        assertThat(minSteps("bab", "aba")).isEqualTo(1);
        assertThat(minSteps("leetcode", "practice")).isEqualTo(5);
        assertThat(minSteps("anagram", "mangaar")).isEqualTo(0);
    }

    public int minSteps(String s, String t) {
        int[] arr = new int[26];
        int length = s.length();
        for (int i = 0; i < length; i++) {
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }
        int sum = 0;
        for (int i : arr) {
            sum += Math.abs(i);
        }
        return sum / 2;
    }

}
