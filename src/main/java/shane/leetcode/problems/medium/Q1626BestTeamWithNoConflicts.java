package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 97 ms Beats 31.29%
 * Memory 42.3 MB Beats 84.35%
 */
public class Q1626BestTeamWithNoConflicts {

    @Test
    public void test() {
        assertThat(bestTeamScore(new int[]{1, 3, 7, 3, 2, 4, 10, 7, 5}, new int[]{4, 5, 2, 1, 1, 2, 4, 1, 4})).isEqualTo(29);
        assertThat(bestTeamScore(new int[]{1, 2, 3, 5}, new int[]{8, 9, 10, 1})).isEqualTo(6);
        assertThat(bestTeamScore(new int[]{4, 5, 6, 5}, new int[]{2, 1, 2, 1})).isEqualTo(16);
        assertThat(bestTeamScore(new int[]{1, 3, 5, 10, 15}, new int[]{1, 2, 3, 4, 5})).isEqualTo(34);
    }

    public int bestTeamScore(int[] scores, int[] ages) {
        final int LENGTH = ages.length;
        List<Player> players = IntStream.range(0, LENGTH)
                .mapToObj(i -> new Player(ages[i], scores[i]))
                .sorted((p1, p2) -> {
                    if (p1.age == p2.age) {
                        return Integer.compare(p1.score, p2.score);
                    }
                    return Integer.compare(p1.age, p2.age);
                })
                .collect(Collectors.toList());

        int[] dp = new int[LENGTH];
        dp[0] = players.get(0).score;
        int max = dp[0];
        for (int i = 1; i < LENGTH; i++) {
            Player player = players.get(i);
            dp[i] = player.score;
            for (int j = 0; j < i; j++) {
                Player other = players.get(j);
                if (other.score <= player.score) {
                    dp[i] = Math.max(dp[i], player.score + dp[j]);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }

    class Player {
        int age;
        int score;

        public Player(int age, int score) {
            this.age = age;
            this.score = score;
        }

        @Override
        public String toString() {
            return "Player{" +
                    "age=" + age +
                    ", score=" + score +
                    '}';
        }
    }
}
