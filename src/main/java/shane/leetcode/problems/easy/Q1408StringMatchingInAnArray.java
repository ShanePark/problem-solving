package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 4ms
 * Beats86.21%
 */
public class Q1408StringMatchingInAnArray {

    @Test
    public void test() {
        assertThat(stringMatching(new String[]{"mass", "as", "hero", "superhero"})).containsExactlyInAnyOrder("as", "hero");
        assertThat(stringMatching(new String[]{"leetcode", "et", "code"})).containsExactlyInAnyOrder("et", "code");
        assertThat(stringMatching(new String[]{"blue", "green", "bu"})).isEmpty();
    }

    public List<String> stringMatching(String[] words) {
        List<String> answer = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i == j)
                    continue;
                if (words[j].contains(words[i])) {
                    answer.add(words[i]);
                    break;
                }
            }
        }
        return answer;
    }

}
