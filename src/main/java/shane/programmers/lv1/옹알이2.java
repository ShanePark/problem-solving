package shane.programmers.lv1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class 옹알이2 {

    @Test
    public void test() {
        assertThat(solution(new String[]{"aya", "yee", "u", "maa"})).isEqualTo(1);
        assertThat(solution(new String[]{"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"})).isEqualTo(2);
    }

    public int solution(String[] babbling) {
        String[] possibles = new String[]{"aya", "ye", "woo", "ma"};
        int answer = 0;
        for (String s : babbling) {
            StringBuilder sb = new StringBuilder(s);
            String last = "";
            while (sb.length() > 0) {
                int length = sb.length();
                for (String possible : possibles) {
                    if (sb.indexOf(possible) == 0 && last != possible) {
                        sb.delete(0, possible.length());
                        last = possible;
                        break;
                    }
                }
                if (length == sb.length()) {
                    break;
                }
            }
            if (sb.length() == 0) {
                answer++;
            }
        }
        return answer;
    }

}
