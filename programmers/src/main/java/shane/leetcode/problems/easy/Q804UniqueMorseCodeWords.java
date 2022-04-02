package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class Q804UniqueMorseCodeWords {

    @Test
    public void test() {
        assertThat(uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"})).isEqualTo(2);
    }

    static final String[] arr = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                sb.append(arr[word.charAt(i) - 'a']);
            }
            set.add(sb.toString());
        }

        return set.size();
    }

}
