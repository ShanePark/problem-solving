package shane.programmers.pccp.mock01;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1 {

    @org.junit.jupiter.api.Test
    public void test() {
        assertThat(solution("edeaaabbccd")).isEqualTo("de");
    }

    public String solution(String input_string) {
        char cur = ' ';
        Set<Character> set = new HashSet<>();
        Set<Character> answer = new HashSet<>();
        for (int i = 0; i < input_string.length(); i++) {
            char c = input_string.charAt(i);
            if (!set.add(c) && cur != c) {
                answer.add(c);
            }
            cur = c;
        }
        if (answer.isEmpty())
            return "N";
        StringBuilder sb = new StringBuilder();
        answer.stream().sorted().forEach(c -> sb.append(c));
        return sb.toString();
    }
}
