package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.ListNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime0msBeats100.00%
 */
public class Q725SplitLinkedListInParts2 {

    @Test
    public void TEST() {
        assertThat(splitListToParts(ListNode.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 3))
                .isEqualTo(new ListNode[]{ListNode.of(1, 2, 3, 4), ListNode.of(5, 6, 7), ListNode.of(8, 9, 10)});
        assertThat(splitListToParts(ListNode.of(1, 2, 3), 5))
                .isEqualTo(new ListNode[]{ListNode.of(1), ListNode.of(2), ListNode.of(3), null, null});
    }

    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] answer = new ListNode[k];
        int size = getSize(head);
        int val = size / k;
        int mod = size % k;
        for (int i = 0; i < k; i++) {
            answer[i] = head;
            int length = val;
            if (i < mod)
                length++;
            for (int j = 0; j < length - 1 && head != null; j++) {
                head = head.next;
            }
            ListNode cur = head;
            if (head != null) {
                head = head.next;
                cur.next = null;
            }
        }
        return answer;
    }

    private int getSize(ListNode head) {
        int answer = 0;
        while (head != null) {
            answer++;
            head = head.next;
        }
        return answer;
    }

}
