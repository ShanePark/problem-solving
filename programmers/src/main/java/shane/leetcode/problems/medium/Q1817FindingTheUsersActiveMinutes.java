package shane.leetcode.problems.medium;

import com.tistory.shanepark.STool;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1817FindingTheUsersActiveMinutes {

    @Test
    public void test() {
        assertThat(findingUsersActiveMinutes(STool.convertToIntArray("[[0,5],[1,2],[0,2],[0,5],[1,3]]"), 5)).containsExactly(0, 2, 0, 0, 0);
        assertThat(findingUsersActiveMinutes(STool.convertToIntArray("[[1,1],[2,2],[2,3]]"), 4)).containsExactly(1, 1, 0, 0);
        assertThat(findingUsersActiveMinutes(STool.convertToIntArray("[[305589003,4136],[305589004,4139],[305589004,4141],[305589004,4137],[305589001,4139],[305589001,4139]]"), 6)).containsExactly(2, 0, 1, 0, 0, 0);
    }

    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] answer = new int[k];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] log : logs) {
            Set<Integer> set = map.getOrDefault(log[0], new HashSet<>());
            set.add(log[1]);
            map.putIfAbsent(log[0], set);
        }

        for (Set<Integer> set : map.values()) {
            answer[set.size() - 1]++;
        }

        return answer;

    }
}
