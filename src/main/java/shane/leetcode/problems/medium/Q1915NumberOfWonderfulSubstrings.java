package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Not My Solution
 */
public class Q1915NumberOfWonderfulSubstrings {

    @Test
    public void test() {
        assertThat(wonderfulSubstrings("aba")).isEqualTo(4);
        assertThat(wonderfulSubstrings("aabb")).isEqualTo(9);
        assertThat(wonderfulSubstrings("he")).isEqualTo(2);
    }

    public long wonderfulSubstrings(String word) {
        long answer = 0;
        int[] prefixOdd = new int[1024];
        prefixOdd[0] = 1;
        int mask = 0;

        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            mask ^= (1 << index);
            answer += prefixOdd[mask];

            for (int i = 0; i < 10; i++) {
                answer += prefixOdd[mask ^ (1 << i)];
            }
            prefixOdd[mask]++;
        }

        return answer;
    }

}
