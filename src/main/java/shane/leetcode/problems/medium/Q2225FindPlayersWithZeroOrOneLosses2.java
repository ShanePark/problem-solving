package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 91 ms Beats 93.45%
 * Memory 91.8 MB Beats 95.88%
 */
public class Q2225FindPlayersWithZeroOrOneLosses2 {

    @Test
    public void test() {
        assertThat(findWinners(Ps.intArray("[[1,3],[2,3],[3,6],[5,6],[5,7],[4,5],[4,8],[4,9],[10,4],[10,9]]")))
                .isEqualTo(Ps.intList("[[1,2,10],[4,5,7,8]]"));
        assertThat(findWinners(Ps.intArray("[[2,3],[1,3],[5,4],[6,4]]")))
                .isEqualTo(Ps.intList("[[1,2,5,6],[]]"));
    }

    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> loseCnt = new HashMap<>();
        for (int[] match : matches) {
            loseCnt.merge(match[1], 1, Integer::sum);
            loseCnt.putIfAbsent(match[0], 0);
        }
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(new ArrayList<>());
        answer.add(new ArrayList<>());

        loseCnt.keySet().stream().sorted().forEach(player -> {
            Integer lose = loseCnt.getOrDefault(player, 0);
            if (lose <= 1) {
                answer.get(lose).add(player);
            }
        });

        return answer;
    }

}
