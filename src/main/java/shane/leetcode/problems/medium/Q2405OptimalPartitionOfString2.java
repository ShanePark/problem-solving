package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 31 ms Beats 73.40%
 * Memory 43 MB Beats 75.16%
 */
public class Q2405OptimalPartitionOfString2 {

    @Test
    public void test() {
        assertThat(partitionString("abacaba")).isEqualTo(4);
        assertThat(partitionString("hdklqkcssgxlvehva")).isEqualTo(4);
        assertThat(partitionString("ssssss")).isEqualTo(6);
    }

    public int partitionString(String s) {
        Set<Character> set = new HashSet<>();
        int length = s.length();
        int size = 1;
        for (int i = 0; i < length; i++) {
            if (!set.add(s.charAt(i))) {
                set.clear();
                set.add(s.charAt(i));
                size++;
            }
        }
        return size;
    }

}
