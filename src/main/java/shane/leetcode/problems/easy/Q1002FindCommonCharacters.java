package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 3 ms Beats 88.78% of users with Java
 */
public class Q1002FindCommonCharacters {

    @Test
    public void test() {
        assertThat(commonChars(new String[]{"bella", "label", "roller"})).containsExactlyInAnyOrder("e", "l", "l");
        assertThat(commonChars(new String[]{"cool", "lock", "cook"})).containsExactlyInAnyOrder("c", "o");
    }

    public List<String> commonChars(String[] words) {
        int[] arr = new int[26];
        Arrays.fill(arr, Integer.MAX_VALUE);

        for (String word : words) {
            int[] cnt = new int[26];
            for (char c : word.toCharArray()) {
                cnt[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                arr[i] = Math.min(arr[i], cnt[i]);
            }
        }
        List<String> answer = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            char c = (char) ('a' + i);
            for (int j = 0; j < arr[i]; j++) {
                answer.add(String.valueOf(c));
            }
        }
        return answer;
    }

}
