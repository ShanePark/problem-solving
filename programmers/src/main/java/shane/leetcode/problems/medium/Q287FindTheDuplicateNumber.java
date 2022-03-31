package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q287FindTheDuplicateNumber {

    @Test
    public void test() {
        assertThat(findDuplicate(new int[]{1, 3, 4, 2, 2})).isEqualTo(2);
        assertThat(findDuplicate(new int[]{3, 1, 3, 4, 2})).isEqualTo(3);
    }

    public int findDuplicate(int[] nums) {
        int[] arr = new int[100001];
        for (int num : nums) {
            if(arr[num]++ == 1)
                return num;
        }
        return -1;
    }
}
