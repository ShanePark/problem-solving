package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * NOt mine
 */
public class Q3307FindTheKthCharacterInStringGameII {

    @Test
    public void test() {
        assertThat(kthCharacter(5, new int[]{0, 0, 0})).isEqualTo('a');
        assertThat(kthCharacter(10, new int[]{0, 1, 0, 1})).isEqualTo('b');
    }

    public char kthCharacter(long k, int[] operations) {
        int answer = 0;
        k--;
        int limit = Math.min(operations.length, Long.SIZE);
        for (int i = 0; i < limit; i++) {
            if (((k >> i) & 1) == 1)
                answer += operations[i];
        }
        return (char) ('a' + answer % 26);
    }

}
