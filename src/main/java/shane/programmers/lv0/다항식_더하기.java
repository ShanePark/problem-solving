package shane.programmers.lv0;

import static org.assertj.core.api.Assertions.assertThat;

public class 다항식_더하기 {

    @org.junit.jupiter.api.Test
    public void test() {
        assertThat(solution("3x + 7 + x")).isEqualTo("4x + 7");
        assertThat(solution("x + x + x")).isEqualTo("3x");
        assertThat(solution("1 + 2")).isEqualTo("3");
        assertThat(solution("x")).isEqualTo("x");
        assertThat(solution("2x")).isEqualTo("2x");
        assertThat(solution("1")).isEqualTo("1");
        assertThat(solution("9x + x +10")).isEqualTo("10x + 10");
        assertThat(solution("0")).isEqualTo("0");
        assertThat(solution("x + 0")).isEqualTo("x");
        assertThat(solution("0x + 0")).isEqualTo("0");
        assertThat(solution("0x + 1")).isEqualTo("1");
        assertThat(solution("x + 1")).isEqualTo("x + 1");
    }

    public String solution(String polynomial) {
        int x = 0;
        int c = 0;

        for (String s : polynomial.split("\\+")) {
            String trim = s.trim();
            if (s.contains("x")) {
                x += trim.length() > 1 ? Integer.parseInt(trim.substring(0, trim.length() - 1)) : 1;
            } else {
                c += Integer.parseInt(trim);
            }
        }

        String first = (x == 0) ? "" : (x == 1) ? "x" : (x + "x");
        String constant = (x > 0 && c == 0) ? "" : (x >= 1) ? " + " + c : String.valueOf(c);
        return first + constant;
    }
}
