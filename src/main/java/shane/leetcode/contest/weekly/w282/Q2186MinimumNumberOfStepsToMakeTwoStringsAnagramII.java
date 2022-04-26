package shane.leetcode.contest.weekly.w282;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q2186MinimumNumberOfStepsToMakeTwoStringsAnagramII {

    @Test
    void test() {
        Assertions.assertThat(minSteps("leetcode", "coats")).isEqualTo(7);
        Assertions.assertThat(minSteps("night", "thing")).isEqualTo(0);
    }

    public int minSteps(String s, String t) {
        int[] arr = new int['z' - 'a' + 1];
        int[] arr2 = new int['z' - 'a' + 1];

        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            arr2[t.charAt(i) - 'a']++;
        }

        int cnt = 0;

        for (int i = 0; i < arr.length; i++) {
            cnt += Math.abs(arr2[i] - arr[i]);
        }

        return cnt;

    }

}
