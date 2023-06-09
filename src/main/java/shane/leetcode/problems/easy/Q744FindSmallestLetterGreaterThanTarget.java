package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 0 ms Beats 100%
 * Memory 44.1 MB Beats 33.61%
 */
public class Q744FindSmallestLetterGreaterThanTarget {

    @Test
    public void test() {
        assertThat(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'a')).isEqualTo('c');
        assertThat(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'c')).isEqualTo('f');
        assertThat(nextGreatestLetter(new char[]{'x', 'x', 'y', 'y'}, 'z')).isEqualTo('x');
    }

    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;
        if (letters[right] <= target) {
            return letters[0];
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] <= target) {
                left = mid + 1;
                continue;
            }
            right = mid;
        }
        return letters[left];
    }

}
