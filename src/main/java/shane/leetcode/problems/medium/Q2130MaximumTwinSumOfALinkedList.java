package shane.leetcode.problems.medium;

import com.github.shanepark.leetcode.ListNode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Q2130MaximumTwinSumOfALinkedList {

    @Test
    void test(){
        Assertions.assertThat(pairSum(ListNode.of(new int[]{5, 4, 2, 1}))).isEqualTo(6);
    }

    public int pairSum(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(head != null) {
            list.add(head.val);
            head = head.next;
        }
        int max = 0;
        for (int i = 0; i < list.size() / 2; i++) {
            max = Math.max(max, list.get(i) + list.get(list.size() - 1 - i));
        }
        return max;
    }
}
