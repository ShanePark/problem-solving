package shane.programmers.challenge2022.backendq3;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1 {

    @Test
    public void test() {
        assertThat(solution(new String[]{"cow", "cow1", "cow2", "cow3", "cow4", "cow9", "cow8", "cow7", "cow6", "cow5"}, "cow")).isEqualTo("cow10");
        assertThat(solution(new String[]{"card", "ace13", "ace16", "banker", "ace17", "ace14"}, "ace15")).isEqualTo("ace15");
    }

    public String solution(String[] registered_list, String new_id) {
        Arrays.sort(registered_list);
        while (true) {
            int index = Arrays.binarySearch(registered_list, new_id);
            if (index < 0)
                return new_id;

            int numIndex = -1;
            for (int i = 0; i < new_id.length(); i++) {
                char c = new_id.charAt(i);
                if ('0' <= c && c <= '9') {
                    numIndex = i;
                    break;
                }
            }
            if (numIndex >= 0) {
                String S = new_id.substring(0, numIndex);
                String N = new_id.substring(numIndex);
                int num = Integer.parseInt(N);
                new_id = S + (num + 1);
            } else {
                new_id = new_id + 1;
            }
        }
    }

}
