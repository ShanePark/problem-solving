package shane.leetcode.contest.weekly.w287;

import com.tistory.shanepark.STool;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2225FindPlayersWithZeroOrOneLosses {

    @Test
    public void test() {
        assertThat(findWinners(STool.convertToIntArray("[[1,3],[2,3],[3,6],[5,6],[5,7],[4,5],[4,8],[4,9],[10,4],[10,9]]")))
                .containsExactly(Arrays.asList(new Integer[]{1, 2, 10}), Arrays.asList(new Integer[]{4, 5, 7, 8}));
    }

    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> loseCntMap = new HashMap<>();
        for (int[] match : matches) {
            loseCntMap.put(match[1], loseCntMap.getOrDefault(match[1], 0) + 1);
            loseCntMap.putIfAbsent(match[0], 0);
        }
        List<Integer> noLose = new ArrayList<>();
        List<Integer> oneLose = new ArrayList<>();
        for (Integer key : loseCntMap.keySet()) {
            Integer loseCnt = loseCntMap.get(key);
            if (loseCnt == 0) {
                noLose.add(key);
            } else if (loseCnt == 1) {
                oneLose.add(key);
            }
        }
        Collections.sort(noLose);
        Collections.sort(oneLose);

        List<List<Integer>> result = new ArrayList<>();
        result.add(noLose);
        result.add(oneLose);
        return result;
    }
}
