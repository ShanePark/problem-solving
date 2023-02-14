package shane.leetcode.problems.medium;

import com.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 42 ms, faster than 14.29% of Java online submissions for Kth Smallest Element in a Sorted Matrix.
 * Memory Usage: 55.2 MB, less than 83.46% of Java
 */
public class Q378KthSmallestElementInASortedMatrix {

    @Test
    public void test() {
        assertThat(kthSmallest(Ps.intArray("[[1,5,9],[10,11,13],[12,13,15]]"), 8)).isEqualTo(13);
        assertThat(kthSmallest(Ps.intArray("[[-5]]"), 1)).isEqualTo(-5);
    }

    public int kthSmallest(int[][] matrix, int k) {
        List<Integer> list = new ArrayList<>();
        for (int[] ints : matrix) {
            for (int i : ints) {
                list.add(i);
            }
        }
        return list.stream().sorted().collect(Collectors.toList()).get(k - 1);
    }
}
