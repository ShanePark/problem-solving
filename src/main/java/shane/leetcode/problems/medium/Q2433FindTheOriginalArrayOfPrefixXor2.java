package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 2ms Beats 59.65%of users with Java
 * Memory Details 57.84MB Beats 96.17%of users with Java
 */
public class Q2433FindTheOriginalArrayOfPrefixXor2 {

    @Test
    public void test() {
        assertThat(findArray(new int[]{5, 2, 0, 3, 1})).containsExactly(5, 7, 2, 3, 2);
        assertThat(findArray(new int[]{13})).containsExactly(13);
    }

    public int[] findArray(int[] pref) {
        int[] answer = new int[pref.length];
        answer[0] = pref[0];
        for (int i = 1; i < pref.length; i++) {
            answer[i] = pref[i - 1] ^ pref[i];
        }
        return answer;
    }

}
