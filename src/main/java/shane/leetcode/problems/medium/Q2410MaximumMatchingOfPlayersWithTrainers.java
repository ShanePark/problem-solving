package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 26
 * ms
 * Beats
 * 66.18%
 */
public class Q2410MaximumMatchingOfPlayersWithTrainers {

    @Test
    public void test() {
        assertThat(matchPlayersAndTrainers(new int[]{4, 7, 9}, new int[]{8, 2, 5, 8})).isEqualTo(2);
        assertThat(matchPlayersAndTrainers(new int[]{1, 1, 1}, new int[]{10})).isEqualTo(1);
        assertThat(matchPlayersAndTrainers(new int[]{1, 1, 1}, new int[]{1, 2, 3, 4, 5})).isEqualTo(3);
    }

    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int player = 0;
        for (int trainer : trainers) {
            if (trainer < players[player])
                continue;
            if (++player == players.length)
                break;
        }
        return player;
    }

}
