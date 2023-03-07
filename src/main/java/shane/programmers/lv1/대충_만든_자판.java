package shane.programmers.lv1;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class 대충_만든_자판 {

    @Test
    public void test() {
        assertThat(solution(new String[]{"ABACD", "BCEFD"}, new String[]{"ABCD", "AABB"})).containsExactly(9, 4);
        assertThat(solution(new String[]{"AA"}, new String[]{"B"})).containsExactly(-1);
        assertThat(solution(new String[]{"AGZ", "BSSS"}, new String[]{"ASA", "BGZ"})).containsExactly(4, 6);
    }

    public int[] solution(String[] keymap, String[] targets) {
        Map<Character, Integer> minMap = new HashMap<>();
        for (String key : keymap) {
            for (int i = 0; i < key.length(); i++) {
                minMap.merge(key.charAt(i), i + 1, Integer::min);
            }
        }
        int[] answer = new int[targets.length];
        loop:
        for (int i = 0; i < targets.length; i++) {
            int cnt = 0;
            String str = targets[i];
            for (int j = 0; j < str.length(); j++) {
                Integer steps = minMap.get(str.charAt(j));
                if (steps == null) {
                    answer[i] = -1;
                    continue loop;
                }
                cnt += steps;
            }
            answer[i] = cnt;
        }
        return answer;
    }

}
