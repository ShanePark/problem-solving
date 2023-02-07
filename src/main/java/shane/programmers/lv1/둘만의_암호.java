package shane.programmers.lv1;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class 둘만의_암호 {

    @Test
    public void test() {
        assertThat(solution("aukks", "wbqd", 5)).isEqualTo("happy");
    }

    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
        Set<Integer> skips = new HashSet<>();
        for (char c : skip.toCharArray()) {
            skips.add(c - 'a');
        }
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            for (int j = 0; j < index; j++) {
                c = (c + 1) % 26;
                if (skips.contains(c)) {
                    j--;
                }
            }
            sb.append((char) (c + 'a'));
        }
        return sb.toString();
    }

}
