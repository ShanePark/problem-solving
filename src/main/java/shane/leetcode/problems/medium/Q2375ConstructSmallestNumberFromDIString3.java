package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 3ms
 * Beats27.70%
 */
public class Q2375ConstructSmallestNumberFromDIString3 {

    @Test
    public void test() {
        assertThat(smallestNumber("IIIDIDDD")).isEqualTo("123549876");
        assertThat(smallestNumber("DDD")).isEqualTo("4321");
    }

    public String smallestNumber(String pattern) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        int dCnt = 0;
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (c == 'I') {
                list.add(i + 2);
                dCnt = 0;
                continue;
            }
            dCnt++;
            for (int j = 0; j < dCnt; j++) {
                list.set(i - j, list.get(i - j) + 1);
            }
            list.add(i + 2 - dCnt);
        }
        return list.stream().map(String::valueOf).collect(Collectors.joining());
    }

}
