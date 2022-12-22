package shane.programmers.lv1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class 크기가_작은_부분문자열 {

    @Test
    public void test() {
        assertThat(solution("3141592", "271")).isEqualTo(2);
        assertThat(solution("500220839878", "7")).isEqualTo(8);
        assertThat(solution("10203", "15")).isEqualTo(3);
    }

    public int solution(String t, String p) {
        int pLength = p.length();
        long pValue = Long.parseLong(p);
        int answer = 0;
        for (int i = 0; i <= t.length() - pLength; i++) {
            long tValue = Long.parseLong(t.substring(i, i + pLength));
            if (tValue <= pValue)
                answer++;
        }
        return answer;
    }

}
