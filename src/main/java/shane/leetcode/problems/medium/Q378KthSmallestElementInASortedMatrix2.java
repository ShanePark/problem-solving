package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 1 ms, faster than 92.44% of Java online submissions for Kth Smallest Element in a Sorted Matrix.
 * Memory Usage: 57.1 MB, less than 39.62% of Java online submissions for Kth Smallest Element in a Sorted Matrix.
 */
public class Q378KthSmallestElementInASortedMatrix2 {

    @Test
    public void test() {
        assertThat(kthSmallest(Ps.intArray("[[-5,-4],[-5,-4]]"), 2)).isEqualTo(-5);
        assertThat(kthSmallest(Ps.intArray("[[1,5,9],[10,11,13],[12,13,15]]"), 8)).isEqualTo(13);
        assertThat(kthSmallest(Ps.intArray("[[-5]]"), 1)).isEqualTo(-5);
    }

    public int kthSmallest(int[][] matrix, int k) {
        final int WIDTH = matrix[0].length;
        final int HEIGHT = matrix.length;
        int left = matrix[0][0];
        int right = matrix[HEIGHT - 1][WIDTH - 1];

        while (left < right) {
            int mid = (left + right - 1) / 2;
            int cnt = 0;
            int j = WIDTH - 1;
            for (int i = 0; i < HEIGHT; i++) {
                while (j >= 0 && matrix[i][j] > mid) {
                    j--;
                }
                cnt += (j + 1);
            }
            
            if (cnt < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
