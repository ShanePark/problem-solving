package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 2ms Beats67.36% 
 */
public class Q1652DefusetheBomb {

    @Test
    public void test() {
        assertThat(decrypt(new int[]{2, 4, 9, 3}, -2)).isEqualTo(new int[]{12, 5, 6, 13});
        assertThat(decrypt(new int[]{5, 7, 1, 4}, 3)).isEqualTo(new int[]{12, 10, 16, 13});
        assertThat(decrypt(new int[]{1, 2, 3, 4}, 0)).isEqualTo(new int[]{0, 0, 0, 0});
    }

    public int[] decrypt(int[] code, int k) {
        if (k == 0)
            return new int[code.length];
        int[] answer = new int[code.length];
        if (k > 0) {
            for (int i = 0; i < code.length; i++) {
                int sum = 0;
                for (int j = i + 1; j - i <= k; j++) {
                    sum += code[j % code.length];
                }
                answer[i] = sum;
            }
            return answer;
        }
        for (int i = 0; i < code.length; i++) {
            int sum = 0;
            for (int j = 1; j <= -k; j++) {
                sum += code[(i - j + code.length) % code.length];
            }
            answer[i] = sum;
        }
        return answer;
    }

}
