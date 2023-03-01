package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 252 ms Beats 37.59%
 * Memory 178.1 MB Beats 6.65%
 */
public class Q2225FindPlayersWithZeroOrOneLosses {

    @Test
    public void test() {
        assertThat(findWinners(Ps.intArray("[[1,3],[2,3],[3,6],[5,6],[5,7],[4,5],[4,8],[4,9],[10,4],[10,9]]")))
                .isEqualTo(Ps.intList("[[1,2,10],[4,5,7,8]]"));
        assertThat(findWinners(Ps.intArray("[[2,3],[1,3],[5,4],[6,4]]")))
                .isEqualTo(Ps.intList("[[1,2,5,6],[]]"));
    }

    public List<List<Integer>> findWinners(int[][] matches) {
        Set<Integer> players = new HashSet<>();
        Map<Integer, Integer> loseCnt = new HashMap<>();
        for (int[] match : matches) {
            int winner = match[0];
            int loser = match[1];
            players.add(winner);
            players.add(loser);
            loseCnt.merge(loser, 1, Integer::sum);
        }
        List<Integer> zeroLose = new ArrayList<>();
        List<Integer> oneLose = new ArrayList<>();

        players.stream().sorted().forEach(player -> {
            Integer lose = loseCnt.getOrDefault(player, 0);
            if (lose == 0) {
                zeroLose.add(player);
            }
            if (lose == 1) {
                oneLose.add(player);
            }
        });
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(zeroLose);
        answer.add(oneLose);
        return answer;
    }

}
