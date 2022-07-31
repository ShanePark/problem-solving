package shane.leetcode.contest.weekly.w304;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2 {

    @Test
    public void test() {
        assertThat(maximumGroups(new int[]{10, 6, 12, 7, 3, 5})).isEqualTo(3);
        assertThat(maximumGroups(new int[]{8, 8})).isEqualTo(1);
        assertThat(maximumGroups(new int[]{1,2,3,4,5})).isEqualTo(2);
    }

    public int maximumGroups(int[] grades) {
        int length = grades.length;
        int n = 0;
        while (length > n) {
            length -= ++n;
        }
        return n;
    }

}
