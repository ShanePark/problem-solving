package shane.leetcode.problems.easy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q1678GoalParserInterpretation {

    @Test
    void test() {
        Assertions.assertThat(interpret("G()(al)")).isEqualTo("Goal");
        Assertions.assertThat(interpret("G()()()()(al)")).isEqualTo("Gooooal");
        Assertions.assertThat(interpret("(al)G(al)()()G")).isEqualTo("alGalooG");
    }

    public String interpret(String command) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < command.length(); i++) {
            char c = command.charAt(i);
            if (c == '(') {
                if (command.charAt(i + 1) == ')') {
                    sb.append('o');
                    i++;
                } else {
                    sb.append("al");
                    i += 3;
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
