package shane.leetcode.contest.weekly.w309;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1 {

    @Test
    public void test() {
        assertThat(checkDistances("abaccb", new int[]{1, 3, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0})).isEqualTo(true);
        assertThat(checkDistances("aa", new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0})).isFalse();
    }

    public boolean checkDistances(String s, int[] distance) {
        int[] arr = new int[26];
        Arrays.fill(arr, -1);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (arr[c - 'a'] == -1) {
                arr[c - 'a'] = i;
            } else {
                if (i - arr[c - 'a'] != distance[c - 'a'] + 1) {
                    return false;
                }
            }
        }
        return true;
    }

}
