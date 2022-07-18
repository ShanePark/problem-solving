package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q944DeleteColumnsToMakeSorted {

    @Test
    public void test() {
        assertThat(minDeletionSize(new String[]{"cba", "daf", "ghi"})).isEqualTo(1);
        assertThat(minDeletionSize(new String[]{"a", "b"})).isEqualTo(0);
        assertThat(minDeletionSize(new String[]{"zyx", "wvu", "tsr"})).isEqualTo(3);
    }

    public int minDeletionSize(String[] strs) {
        int height = strs.length;
        int width = strs[0].length();
        int cnt = 0;
        for (int i = 0; i < width; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < height; j++) {
                char next = strs[j].charAt(i);
                if (c > next) {
                    cnt++;
                    break;
                }
                c = next;
            }
        }
        return cnt;
    }
}
