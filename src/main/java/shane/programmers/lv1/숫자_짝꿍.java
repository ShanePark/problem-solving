package shane.programmers.lv1;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class 숫자_짝꿍 {

    @Test
    public void test() {
        assertThat(solution("100", "2345")).isEqualTo("-1");
        assertThat(solution("12321", "42531")).isEqualTo("321");
        assertThat(solution("100", "203045")).isEqualTo("0");
    }

    public String solution(String X, String Y) {
        Map<Integer, Integer> cntMapX = new HashMap<>();
        Map<Integer, Integer> cntMapY = new HashMap<>();
        for (int i = 0; i < X.length(); i++) {
            cntMapX.merge(X.charAt(i) - '0', 1, Integer::sum);
        }
        for (int i = 0; i < Y.length(); i++) {
            cntMapY.merge(Y.charAt(i) - '0', 1, Integer::sum);
        }

        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = Math.min(cntMapX.getOrDefault(i, 0), cntMapY.getOrDefault(i, 0));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 9; i > 0; i--) {
            for (int j = 0; j < arr[i]; j++) {
                sb.append(i);
            }
        }

        if (sb.length() == 0) {
            return arr[0] == 0 ? "-1" : "0";
        }
        for (int i = 0; i < arr[0]; i++) {
            sb.append(0);
        }
        return sb.toString();
    }

}
