package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

public class Q3169CountDaysWithoutMeetings {

    @Test
    public void test() {
        assertThat(countDays(10, Ps.intArray("[[5,7],[1,3],[9,10]]"))).isEqualTo(2);
        assertThat(countDays(5, Ps.intArray("[[2,4],[1,3]]"))).isEqualTo(1);
    }

    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
        int count = meetings[0][0] - 1;
        int n = meetings.length;
        for (int i = 1; i < n; i++) {
            if (meetings[i][0] <= meetings[i - 1][1]) {
                if (meetings[i][1] < meetings[i - 1][1]) {
                    meetings[i][1] = meetings[i - 1][1];
                }
            } else {
                int dy = meetings[i][0] - meetings[i - 1][1];
                count += dy - 1;
            }
        }
        count += days - meetings[n - 1][1];
        return count;
    }
}
