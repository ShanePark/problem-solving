package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1051HeightChecker2 {

    @Test
    public void test() {
        assertThat(heightChecker(new int[]{1, 1, 4, 2, 1, 3})).isEqualTo(3);
        assertThat(heightChecker(new int[]{5, 1, 2, 3, 4})).isEqualTo(5);
        assertThat(heightChecker(new int[]{1, 2, 3, 4, 5})).isEqualTo(0);
    }

    public int heightChecker(int[] heights) {
        int[] bucket = new int[101];
        for (int height : heights) {
            bucket[height]++;
        }

        int bucketIndex = 0;
        int cnt = 0;
        for (int i = 0; i < heights.length; i++) {
            while (bucket[bucketIndex] == 0) {
                bucketIndex++;
            }
            bucket[bucketIndex]--;
            if (heights[i] != bucketIndex) {
                cnt++;
            }
        }

        return cnt;
    }
}
