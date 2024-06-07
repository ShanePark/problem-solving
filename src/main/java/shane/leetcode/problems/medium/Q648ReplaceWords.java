package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 738 ms Beats 5.05% of users with Java
 */
public class Q648ReplaceWords {

    @Test
    public void test() {
        assertThat(replaceWords(List.of("cat", "bat", "rat"), "the cattle was rattled by the battery"))
                .isEqualTo("the cat was rat by the bat");
        assertThat(replaceWords(List.of("a", "b", "c"), "aadsfasf absbs bbab cadsfafs"))
                .isEqualTo("a a b c");
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        StringBuilder sb = new StringBuilder();
        Set<String> set = new HashSet<>(dictionary);
        for (String s : sentence.split(" ")) {
            String word = findDict(set, s);
            sb.append(word);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private String findDict(Set<String> set, String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(c);
            if (set.contains(sb.toString())) {
                return sb.toString();
            }
        }
        return s;
    }

}
