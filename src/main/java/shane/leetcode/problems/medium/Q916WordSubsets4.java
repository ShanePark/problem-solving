package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Runtime
 * 13ms
 * Beats81.40%
 */
public class Q916WordSubsets4 {

    @Test
    public void test() {
        assertThat(wordSubsets(new String[]{"amazon", "apple", "facebook", "google", "leetcode"}, new String[]{"e", "o"})).containsExactly("facebook", "google", "leetcode");
        assertThat(wordSubsets(new String[]{"amazon", "apple", "facebook", "google", "leetcode"}, new String[]{"l", "e"})).containsExactly("apple", "google", "leetcode");
    }

    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> answer = new ArrayList<>();
        int[] maxCnt = new int[26];
        for (String s : words2) {
            int[] cnt = countChars(s);
            for (int i = 0; i < 26; i++) {
                maxCnt[i] = Math.max(maxCnt[i], cnt[i]);
            }
        }
        mainLoop:
        for (String s : words1) {
            int[] cnt = countChars(s);
            for (int i = 0; i < 26; i++) {
                if (cnt[i] < maxCnt[i])
                    continue mainLoop;
            }
            answer.add(s);
        }
        return answer;
    }

    private int[] countChars(String s) {
        int[] answer = new int[26];
        for (char c : s.toCharArray()) {
            answer[c - 'a']++;
        }
        return answer;
    }

}
