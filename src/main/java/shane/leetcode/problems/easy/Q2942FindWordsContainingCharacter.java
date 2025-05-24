package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2942FindWordsContainingCharacter {

    @Test
    public void test() {
        assertThat(findWordsContaining(new String[]{"leet", "code"}, 'e')).containsExactly(0, 1);
        assertThat(findWordsContaining(new String[]{"abc", "bcd", "aaaa", "cbc"}, 'a')).containsExactly(0, 2);
        assertThat(findWordsContaining(new String[]{"abc", "bcd", "aaaa", "cbc"}, 'z')).isEmpty();
    }

    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].indexOf(x) >= 0)
                answer.add(i);
        }
        return answer;
    }

}
