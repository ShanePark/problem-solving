package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 2ms
 * Beats51.83%
 */
public class Q1980FindUniqueBinaryString2 {

    @Test
    public void test() {
        String[] arr = {"01", "10"};
        assertThat(findDifferentBinaryString(arr)).isNotIn(Arrays.asList(arr));
        String[] arr2 = {"00", "01"};
        assertThat(findDifferentBinaryString(arr2)).isNotIn(Arrays.asList(arr2));
        String[] arr3 = {"111", "011", "001"};
        assertThat(findDifferentBinaryString(arr3)).isNotIn(Arrays.asList(arr3));
    }

    public String findDifferentBinaryString(String[] nums) {
        return dfs(new StringBuilder(), new HashSet<>(Arrays.asList(nums)), nums[0].length());
    }

    private String dfs(StringBuilder sb, Set<String> set, int length) {
        if (sb.length() == length) {
            if (set.contains(sb.toString()))
                return null;
            return sb.toString();
        }
        sb.append("0");
        String try0 = dfs(sb, set, length);
        if (try0 != null) {
            return try0;
        }
        sb.setCharAt(sb.length() - 1, '1');
        String try1 = dfs(sb, set, length);
        if (try1 != null) {
            return try1;
        }
        sb.deleteCharAt(sb.length() - 1);
        return null;
    }

}
