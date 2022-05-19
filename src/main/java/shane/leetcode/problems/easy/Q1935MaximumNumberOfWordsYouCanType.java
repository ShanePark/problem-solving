package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1935MaximumNumberOfWordsYouCanType {

    @Test
    public void test() {
        assertThat(canBeTypedWords("hello world", "ad")).isEqualTo(1);
        assertThat(canBeTypedWords("leet code", "lt")).isEqualTo(1);
        assertThat(canBeTypedWords("leet code", "e")).isEqualTo(0);
    }

    public int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> broken = new HashSet<>();
        for (int i = 0; i < brokenLetters.length(); i++) {
            broken.add(brokenLetters.charAt(i));
        }
        int brokenSize = brokenLetters.length();

        int cnt = 0;
        String[] arr = text.split(" ");
        for (String s : arr) {
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < s.length(); i++) {
                set.add(s.charAt(i));
            }
            int size = set.size();
            set.addAll(broken);
            if (size + brokenSize == set.size())
                cnt++;
        }
        return cnt;
    }
}
