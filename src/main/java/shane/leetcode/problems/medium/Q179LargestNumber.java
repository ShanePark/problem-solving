package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime11msBeats12.70%
 */
public class Q179LargestNumber {

    @Test
    public void test() {
        assertThat(largestNumber(new int[]{10, 2})).isEqualTo("210");
        assertThat(largestNumber(new int[]{3, 30, 34, 5, 9})).isEqualTo("9534330");
        assertThat(largestNumber(new int[]{3, 30, 32, 5, 9})).isEqualTo("9533230");
        assertThat(largestNumber(new int[]{111311, 1113})).isEqualTo("1113111311");
        assertThat(largestNumber(new int[]{0, 0})).isEqualTo("0");
    }

    public String largestNumber(int[] nums) {
        List<String> list = Arrays.stream(nums)
                .boxed()
                .map(String::valueOf)
                .sorted((n1, n2) -> (n2 + n1).compareTo(n1 + n2))
                .collect(Collectors.toList());
        return "0".equals(list.get(0)) ? "0" : String.join("", list);
    }

}
