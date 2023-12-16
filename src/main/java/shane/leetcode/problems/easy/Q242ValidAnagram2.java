package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 5ms Beats 54.58%of users with Java
 * Memory Details 41.86MB Beats 88.76%of users with Java
 */
public class Q242ValidAnagram2 {

    @Test
    public void test() {
        assertThat(isAnagram("anagram", "nagaram")).isTrue();
        assertThat(isAnagram("rat", "cat")).isFalse();
    }

    public boolean isAnagram(String s, String t) {
        int length = s.length();
        if (length != t.length())
            return false;
        int[] arr = new int[26];
        for (int i = 0; i < length; i++) {
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0)
                return false;
        }
        return true;
    }
}
