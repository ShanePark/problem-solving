package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime15msBeats76.57%
 */
public class Q2491DividePlayersIntoTeamsOfEqualSkill {

    @Test
    public void test() {
        assertThat(dividePlayers(new int[]{3, 2, 5, 1, 3, 4})).isEqualTo(22);
        assertThat(dividePlayers(new int[]{3, 4})).isEqualTo(12);
        assertThat(dividePlayers(new int[]{1, 1, 2, 3})).isEqualTo(-1);
    }

    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int sum = skill[0] + skill[skill.length - 1];
        int teamSize = skill.length / 2;
        long answer = 0;
        for (int i = 0; i < teamSize; i++) {
            int left = skill[i];
            int right = skill[skill.length - 1 - i];
            if (left + right != sum) {
                return -1;
            }
            answer += (long) left * right;
        }
        return answer;
    }

}
