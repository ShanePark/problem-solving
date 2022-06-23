package shane.programmers.lv3;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class GemShopping4 {

    @Test
    public void test() {
        assertThat(solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"})).containsExactly(3, 7);
        assertThat(solution(new String[]{"AA", "AB", "AC", "AA", "AC"})).containsExactly(1, 3);
        assertThat(solution(new String[]{"XYZ", "XYZ", "XYZ"})).containsExactly(1, 1);
        assertThat(solution(new String[]{"ZZZ", "YYY", "NNNN", "YYY", "BBB"})).containsExactly(1, 5);
    }

    public static int[] solution(String[] gems) {
        int distinct = (int) Arrays.stream(gems).distinct().count();
        for (int count = distinct; ; count++) {
            for (int i = 0; i + count <= gems.length; i++) {
                Set<String> set = new HashSet<>();
                for (int j = i; j < i + count; j++) {
                    set.add(gems[j]);
                }
                if (set.size() == distinct)
                    return new int[]{i + 1, i + count};
            }
        }
    }
}
