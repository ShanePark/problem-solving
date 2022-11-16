package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 0 ms Beats 100%
 * Memory 40.8 MB Beats 44.2%
 */
public class Q374GuessNumberHigherOrLower {

    @Test
    public void test() {
        assertThat(new Solution(4).guessNumber(4)).isEqualTo(4);
        assertThat(new Solution(2).guessNumber(2)).isEqualTo(2);
        assertThat(new Solution(6).guessNumber(10)).isEqualTo(6);
        assertThat(new Solution(1).guessNumber(1)).isEqualTo(1);
        assertThat(new Solution(1).guessNumber(2)).isEqualTo(1);
    }

    class GuessGame {
        final int num;

        GuessGame(int num) {
            this.num = num;
        }


        public int guess(int n) {
            if (num < n) {
                return -1;
            } else if (n < num) {
                return 1;
            }
            return 0;
        }

    }

    class Solution extends GuessGame {

        Solution(int num) {
            super(num);
        }

        public int guessNumber(int n) {
            int left = 1;
            int right = n;
            while (left < right) {
                int mid = left + (right - left) / 2;
                int guess = guess(mid);
                if (guess == 1) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left;
        }
    }
}
