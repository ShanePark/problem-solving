package shane.programmers.lv1;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class 성격_유형_검사하기 {

    @Test
    public void test() {
        assertThat(solution(new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[]{5, 3, 2, 7, 5})).isEqualTo("TCMA");
        assertThat(solution(new String[]{"TR", "RT", "TR"}, new int[]{7, 1, 3})).isEqualTo("RCJA");
    }

    public String solution(String[] survey, int[] choices) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < survey.length; i++) {
            String s = survey[i];
            int score = choices[i];
            if (score < 4) {
                map.merge(s.charAt(0), 4 - score, Integer::sum);
            } else {
                map.merge(s.charAt(1), score - 4, Integer::sum);
            }
        }

        StringBuilder sb = new StringBuilder();

        calc(map, sb, 'R', 'T');
        calc(map, sb, 'C', 'F');
        calc(map, sb, 'J', 'M');
        calc(map, sb, 'A', 'N');

        return sb.toString();
    }

    private static void calc(Map<Character, Integer> map, StringBuilder sb, char a, char b) {
        if (map.getOrDefault(a, 0) >= map.getOrDefault(b, 0)) {
            sb.append(a);
        } else {
            sb.append(b);
        }
    }
}
