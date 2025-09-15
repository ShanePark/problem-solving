package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 2ms
 * Beats91.65%
 */
public class Q1935MaximumNumberOfWordsYouCanType3 {

    @Test
    public void test() {
        assertThat(canBeTypedWords("hello world", "ad")).isEqualTo(1);
        assertThat(canBeTypedWords("leet code", "lt")).isEqualTo(1);
        assertThat(canBeTypedWords("leet code", "e")).isEqualTo(0);
    }

    public int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> broken = new HashSet<>();
        for (char c : brokenLetters.toCharArray()) {
            broken.add(c);
        }
        int answer = 0;
        loop:
        for (String s : text.split(" ")) {
            for (char c : s.toCharArray()) {
                if (broken.contains(c))
                    continue loop;
            }
            answer++;
        }
        return answer;
    }

}
