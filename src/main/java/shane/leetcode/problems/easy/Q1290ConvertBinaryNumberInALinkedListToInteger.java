package shane.leetcode.problems.easy;

import io.github.shanepark.leetcode.ListNode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q1290ConvertBinaryNumberInALinkedListToInteger {

    @Test
    void test() {
        Assertions.assertThat(getDecimalValue(ListNode.of(new int[]{1, 0, 1}))).isEqualTo(5);
    }

    public int getDecimalValue(ListNode head) {
        int num = 0;
        while (head != null) {
            num = (num << 1) + head.val;
            head = head.next;
        }
        return num;
    }

}
