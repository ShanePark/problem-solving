package shane.programmers.lv1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class 문자열_나누기 {

    @Test
    public void test() {
        assertThat(solution("banana")).isEqualTo(3);
        assertThat(solution("abracadabra")).isEqualTo(6);
        assertThat(solution("aaabbaccccabba")).isEqualTo(3);
    }

    public int solution(String s) {
        int cnt1 = 0;
        int cnt2 = 0;
        char answer = 0;
        char current = ' ';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (current == ' ') {
                current = c;
                cnt1 = 1;
            } else if (current == c) {
                cnt1++;
            } else {
                cnt2++;
            }
            if (cnt1 == cnt2) {
                current = ' ';
                cnt1 = 0;
                cnt2 = 0;
                answer++;
            }
        }
        if (current != ' ') {
            answer++;
        }
        return answer;
    }
}
