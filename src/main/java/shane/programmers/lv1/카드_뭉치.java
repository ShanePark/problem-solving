package shane.programmers.lv1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class 카드_뭉치 {

    @Test
    public void test() {
        assertThat(solution(new String[]{"i", "drink", "water"}, new String[]{"want", "to"}, new String[]{"i", "want", "to", "drink", "water"})).isEqualTo("Yes");
        assertThat(solution(new String[]{"i", "water", "drink"}, new String[]{"want", "to"}, new String[]{"i", "want", "to", "drink", "water"})).isEqualTo("No");
    }

    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int c1 = 0;
        int c2 = 0;
        for (int i = 0; i < goal.length; i++) {
            String word = goal[i];
            if (c1 < cards1.length && word.equals(cards1[c1])) {
                c1++;
            } else if (c2 < cards2.length && word.equals(cards2[c2])) {
                c2++;
            } else {
                return "No";
            }
        }
        return "Yes";
    }
}
