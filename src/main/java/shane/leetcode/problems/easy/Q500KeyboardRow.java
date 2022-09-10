package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 3 ms, faster than 22.61% of Java online submissions for Keyboard Row.
 * Memory Usage: 42.2 MB, less than 33.14% of Java online submissions for Keyboard Row.
 */
public class Q500KeyboardRow {

    @Test
    public void test() {
        assertThat(findWords(new String[]{"Aasdfghjkl", "Qwertyuiop", "zZxcvbnm"})).containsExactly("Aasdfghjkl", "Qwertyuiop", "zZxcvbnm");
        assertThat(findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"})).containsExactly("Alaska", "Dad");
        assertThat(findWords(new String[]{"omk"})).containsExactly();
        assertThat(findWords(new String[]{"adsdf", "sfd"})).containsExactly("adsdf", "sfd");
    }

    public String[] findWords(String[] words) {
        Map<Character, Integer> map = new HashMap<>();
        String[] lines = new String[]{"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        for (int i = 0; i < 3; i++) {
            String str = lines[i];
            for (int j = 0; j < str.length(); j++) {
                map.put(str.charAt(j), i);
            }
        }

        return Arrays.stream(words)
                .filter(
                        s -> {
                            s = s.toLowerCase();
                            final int LINE = map.get(s.charAt(0));
                            for (int i = 1; i < s.length(); i++) {
                                if (LINE != map.get(s.charAt(i))) {
                                    return false;
                                }
                            }
                            return true;
                        }
                ).toArray(String[]::new);
    }

}
