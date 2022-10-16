package shane.programmers.lv0;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class 숨어있는_숫자의_덧셈2 {
    @Test
    public void test() {
        assertThat(solution("1a2b3c4d123Z")).isEqualTo(133);
    }

    public int solution(String my_string) {
        int answer = 0;
        int cur = 0;
        for (int i = 0; i < my_string.length(); i++) {
            char c = my_string.charAt(i);
            if ('0' <= c && c <= '9') {
                cur = cur * 10 + c - '0';
            } else {
                answer += cur;
                cur = 0;
            }
        }
        return answer + cur;
    }
}
