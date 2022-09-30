package shane.programmers.lv0;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class 옹알이 {

    @Test
    public void test() {
        assertThat(solution(new String[]{"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"})).isEqualTo(2);
        assertThat(solution(new String[]{"ayayewooma"})).isEqualTo(1);
        assertThat(solution(new String[]{"aya", "yee", "u", "maa"})).isEqualTo(1);
    }

    public int solution(String[] babbling) {
        String[] possible = new String[]{"aya", "ye", "woo", "ma"};
        int cnt = 0;
        for (String s : babbling) {
            if (possible(new StringBuilder(s), possible, "")) {
                cnt++;
            }
        }
        return cnt;
    }

    private boolean possible(StringBuilder sb, String[] possible, String before) {
        if (sb.length() == 0)
            return true;
        for (String p : possible) {
            if (sb.toString().startsWith(p) && !before.equals(p)) {
                sb.delete(0, p.length());
                return possible(sb, possible, p);
            }
        }
        return false;
    }

}
