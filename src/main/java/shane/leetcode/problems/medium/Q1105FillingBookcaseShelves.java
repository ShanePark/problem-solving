package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1105FillingBookcaseShelves {

    @Test
    public void test() {
        assertThat(minHeightShelves(Ps.intArray("[[1,1],[2,3],[2,3],[1,1],[1,1],[1,1],[1,2]]"), 4)).isEqualTo(6);
        assertThat(minHeightShelves(Ps.intArray("[[1,3],[2,4],[3,2]]"), 6)).isEqualTo(4);
    }

    public int minHeightShelves(int[][] books, int shelfWidth) {
        int[] dp = new int[books.length];
        dp[0] = books[0][1];

        for (int i = 1; i < books.length; i++) {
            int thickness = books[i][0];
            int height = books[i][1];
            dp[i] = dp[i - 1] + height;

            for (int j = i - 1; j >= 0; j--) {
                if (shelfWidth < books[j][0] + thickness)
                    break;
                thickness += books[j][0];
                height = Math.max(height, books[j][1]);
                if (j == 0) {
                    dp[i] = height;
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[j - 1] + height);
            }
        }
        return dp[books.length - 1];
    }

}
