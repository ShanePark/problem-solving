package shane.programmers.lv0;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class 외계어_사전 {

    @Test
    public void test() {
        assertThat(solution(new String[]{"p", "o", "s"}, new String[]{"sod", "eocd", "qixm", "adio", "soo"})).isEqualTo(2);
        assertThat(solution(new String[]{"z", "d", "x"}, new String[]{"def", "dww", "dzx", "loveaw"})).isEqualTo(1);
    }

    public int solution(String[] spell, String[] dic) {
        Arrays.sort(spell);
        StringBuilder sb = new StringBuilder();
        for (String s : spell) {
            sb.append(s);
        }
        for (String s : dic) {
            if (s.length() != sb.length())
                continue;
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            if (sb.toString().equals(new String(chars))) {
                return 1;
            }
        }
        return 2;
    }

}
