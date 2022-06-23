package shane.programmers.lv3;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("ALL")
public class GemShopping5 {

    @Test
    public void test() {
        assertThat(solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"})).containsExactly(3, 7);
        assertThat(solution(new String[]{"XYZ", "XYZ", "XYZ"})).containsExactly(1, 1);
        assertThat(solution(new String[]{"AA", "AB", "AC", "AA", "AC"})).containsExactly(1, 3);
        assertThat(solution(new String[]{"ZZZ", "YYY", "NNNN", "YYY", "BBB"})).containsExactly(1, 5);
    }

    public static int[] solution(String[] gems) {
        int min = Integer.MAX_VALUE;
        int[] answer = new int[2];
        long count = Arrays.stream(gems).distinct().count();

        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        set.add(gems[0]);
        map.put(gems[0], 1);

        int right = 0;
        for (int left = 0; left < gems.length; left++) {
            // move right ->
            while (set.size() < count && right < gems.length - 1) {
                right++;
                map.merge(gems[right], 1, Integer::sum);
                set.add(gems[right]);
            }

            if (set.size() == count && right - left < min) {
                min = right - left - 1;
                answer = new int[]{left + 1, right + 1};
            }

            // prepare for next
            Integer firstCnt = map.get(gems[left]);
            if (firstCnt == 1) {
                set.remove(gems[left]);
            }
            map.put(gems[left], firstCnt - 1);
            if (left == right)
                right++;
        }
        return answer;
    }
}
