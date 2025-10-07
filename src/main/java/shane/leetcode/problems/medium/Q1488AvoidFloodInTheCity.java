package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class Q1488AvoidFloodInTheCity {

    @Test
    public void test1() {
        int[] rains = {1, 2, 3, 4};
        int[] answer = avoidFlood(rains);
        checkAnswer(rains, answer);
    }

    @Test
    public void test2() {
        int[] rains = {1, 2, 0, 0, 2, 1};
        int[] answer = avoidFlood(rains);
        checkAnswer(rains, answer);
    }

    @Test
    public void test3() {
        int[] answer = avoidFlood(new int[]{1, 2, 0, 1, 2});
        assertThat(answer).isEmpty();
    }

    @Test
    public void test4() {
        int[] rains = {69,0,0,0,69};
        int[] answer = avoidFlood(rains);
        checkAnswer(rains, answer);
    }

    private void checkAnswer(int[] rains, int[] answer) {
        assertThat(answer.length).isEqualTo(rains.length);
        Set<Integer> fullLakes = new HashSet<>();
        for (int i = 0; i < rains.length; i++) {
            if (rains[i] > 0) {
                assertThat(answer[i]).isEqualTo(-1);
                assertThat(fullLakes).doesNotContain(rains[i]);
                fullLakes.add(rains[i]);
                continue;
            }
            assertThat(answer[i]).isGreaterThan(0);
            fullLakes.remove(answer[i]);
        }
    }


    public int[] avoidFlood(int[] rains) {
        int[] answer = new int[rains.length];
        Map<Integer, Integer> lakeDayMap = new HashMap<>();
        TreeSet<Integer> dryDays = new TreeSet<>();

        for (int i = 0; i < rains.length; i++) {
            if (rains[i] == 0) {
                dryDays.add(i);
                answer[i] = 1;
                continue;
            }
            int lake = rains[i];
            if (lakeDayMap.containsKey(lake)) {
                int prevDay = lakeDayMap.get(lake);
                Integer dryDay = dryDays.higher(prevDay);
                if (dryDay == null) {
                    return new int[]{};
                }
                answer[dryDay] = lake;
                dryDays.remove(dryDay);
            }
            lakeDayMap.put(lake, i);
            answer[i] = -1;
        }

        return answer;
    }

}
