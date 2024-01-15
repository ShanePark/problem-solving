package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 101 ms Beats 30.82% of users with Java
 */
public class Q2225FindPlayersWithZeroOrOneLosses3 {

    @Test
    public void test() {
        assertThat(findWinners(Ps.intArray("[[1,3],[2,3],[3,6],[5,6],[5,7],[4,5],[4,8],[4,9],[10,4],[10,9]]")))
                .isEqualTo(Ps.intList("[[1,2,10],[4,5,7,8]]"));
        assertThat(findWinners(Ps.intArray("[[2,3],[1,3],[5,4],[6,4]]")))
                .isEqualTo(Ps.intList("[[1,2,5,6],[]]"));
    }

    public List<List<Integer>> findWinners(int[][] matches) {
        Set<Integer> players = new HashSet<>();
        Map<Integer, Integer> lostCnt = new HashMap<>();
        for (int[] match : matches) {
            int winner = match[0];
            int loser = match[1];
            players.add(winner);
            players.add(loser);
            lostCnt.merge(loser, 1, Integer::sum);
        }
        players.removeAll(lostCnt.keySet());
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(new ArrayList<>(players));
        answer.add(new ArrayList<>());
        lostCnt.entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .forEach(e -> answer.get(1).add(e.getKey()));
        Collections.sort(answer.get(0));
        Collections.sort(answer.get(1));

        return answer;
    }

}
