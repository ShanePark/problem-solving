package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 62 ms, faster than 62.97% of Java online submissions for Optimal Partition of String.
 * Memory Usage: 61.1 MB, less than 50.91% of Java online submissions for Optimal Partition of String.
 */
public class Q2405OptimalPartitionOfString {

    @Test
    public void test() {
        assertThat(partitionString("abacaba")).isEqualTo(4);
        assertThat(partitionString("ssssss")).isEqualTo(6);
    }

    public int partitionString(String s) {
        int cnt = 1;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!set.add(c)) {
                cnt++;
                set.clear();
                set.add(c);
            }
        }
        return cnt;
    }
}
