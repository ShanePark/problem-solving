package shane.leetcode.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class Q3LongestSubstringWithoutRepeatingCharacters {

    @Test
    void test() {
        Assertions.assertThat(lengthOfLongestSubstring("abcabcbb")).isEqualTo(3);
        Assertions.assertThat(lengthOfLongestSubstring("bbbbb")).isEqualTo(1);
        Assertions.assertThat(lengthOfLongestSubstring("pwwkew")).isEqualTo(3);
        Assertions.assertThat(lengthOfLongestSubstring("aab")).isEqualTo(2);
        Assertions.assertThat(lengthOfLongestSubstring("dvdf")).isEqualTo(3);
    }

    public int lengthOfLongestSubstring(String s) {
        Queue<Character> q = new LinkedList<>();
        int max = 0;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (q.contains(arr[i])) {
                max = Math.max(max, q.size());
                while (!q.isEmpty() && q.poll() != arr[i]) {
                }
            }
            q.offer(arr[i]);
        }
        return Math.max(max, q.size());
    }
}
