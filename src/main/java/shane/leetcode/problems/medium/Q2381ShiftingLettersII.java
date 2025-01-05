package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 53
 * ms
 * Beats
 * 14.15%
 */
public class Q2381ShiftingLettersII {

    @Test
    public void test() {
        assertThat(shiftingLetters("abc", Ps.intArray("[[0,1,0],[1,2,1],[0,2,1]]"))).isEqualTo("ace");
        assertThat(shiftingLetters("dztz", Ps.intArray("[[0,0,0],[1,1,1]]"))).isEqualTo("catz");
        assertThat(shiftingLetters("dztz", Ps.intArray("[[0,0,0],[1,1,0]]"))).isEqualTo("cytz");
    }

    public String shiftingLetters(String s, int[][] shifts) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2] == 1 ? 1 : -1;
            map.merge(start, direction, Integer::sum);
            map.merge(end + 1, -direction, Integer::sum);
        }
        Queue<Map.Entry<Integer, Integer>> q = new LinkedList<>();
        map.entrySet().stream()
                .sorted(Comparator.comparingInt(Map.Entry::getKey))
                .forEach(q::offer);
        StringBuilder sb = new StringBuilder();
        int shift = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            while (!q.isEmpty() && q.peek().getKey() <= i) {
                shift += q.poll().getValue();
            }
            int index = ((c - 'a') + shift) % 26;
            if (index < 0)
                index += 26;
            sb.append((char) ('a' + index));
        }
        return sb.toString();
    }

}
