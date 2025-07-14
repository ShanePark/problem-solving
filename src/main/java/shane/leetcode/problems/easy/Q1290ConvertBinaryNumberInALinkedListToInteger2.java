package shane.leetcode.problems.easy;

import io.github.shanepark.leetcode.ListNode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Runtime
 * 0
 * ms
 * Beats
 * 100.00%
 */
public class Q1290ConvertBinaryNumberInALinkedListToInteger2 {

    @Test
    void test() {
        Assertions.assertThat(getDecimalValue(ListNode.of(1, 0, 1))).isEqualTo(5);
    }

    public int getDecimalValue(ListNode head) {
        int answer = 0;
        while (head != null) {
            answer <<= 1;
            answer += head.val;
            head = head.next;
        }
        return answer;
    }

}
