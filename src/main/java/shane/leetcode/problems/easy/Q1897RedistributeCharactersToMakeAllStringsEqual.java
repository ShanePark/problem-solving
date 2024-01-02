package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 4ms Beats 43.02%of users with Java
 * Memory Details 43.64MB Beats 12.83%of users with Java
 */
public class Q1897RedistributeCharactersToMakeAllStringsEqual {

    @Test
    public void test() {
        assertThat(makeEqual(new String[]{"abc", "aabc", "bc"})).isTrue();
        assertThat(makeEqual(new String[]{"ab", "a"})).isFalse();
    }

    public boolean makeEqual(String[] words) {
        int[] arr = new int[26];
        Arrays.stream(words).forEach(w -> w.chars().forEach(i -> arr[i - 'a']++));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % words.length != 0)
                return false;
        }
        return true;
    }

}
