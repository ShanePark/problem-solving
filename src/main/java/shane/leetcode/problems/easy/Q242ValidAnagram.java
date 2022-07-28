package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 3 ms, faster than 95.30% of Java online submissions for Valid Anagram.
 * Memory Usage: 42.2 MB, less than 96.93% of Java online submissions for Valid Anagram.
 */
public class Q242ValidAnagram {

    @Test
    public void test() {
        assertThat(isAnagram("anagram", "nagaram")).isTrue();
        assertThat(isAnagram("rat", "cat")).isFalse();
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }
        for (int i : arr) {
            if (i != 0)
                return false;
        }
        return true;
    }
}
