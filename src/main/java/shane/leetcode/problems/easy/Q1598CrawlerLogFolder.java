package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime1msBeats99.42%
 */
public class Q1598CrawlerLogFolder {

    @Test
    public void test() {
        assertThat(minOperations(new String[]{"d1/", "d2/", "../", "d21/", "./"})).isEqualTo(2);
        assertThat(minOperations(new String[]{"d1/", "d2/", "./", "d3/", "../", "d31/"})).isEqualTo(3);
        assertThat(minOperations(new String[]{"d1/", "../", "../", "../"})).isEqualTo(0);
    }

    public int minOperations(String[] logs) {
        int depth = 0;
        for (String log : logs) {
            switch (log) {
                case "./":
                    break;
                case "../":
                    depth = Math.max(0, depth - 1);
                    break;
                default:
                    depth++;
            }
        }
        return depth;
    }

}
