package shane.leetcode.problems.easy

import com.github.shanepark.leetcode.ListNode
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

/**
 * Runtime 238 ms Beats 63.17%
 * Memory 34.4 MB Beats 25.64%
 */
class Q876MiddleOfTheLinkedListK {

    @Test
    fun test() {
        Assertions.assertThat(middleNode(ListNode.of(1, 2, 3, 4, 5))).isEqualTo(ListNode.of(3, 4, 5))
        Assertions.assertThat(middleNode(ListNode.of(1, 2, 3, 4, 5, 6))).isEqualTo(ListNode.of(4, 5, 6))
        Assertions.assertThat(middleNode(ListNode.of(1))).isEqualTo(ListNode.of(1))
        Assertions.assertThat(middleNode(ListNode.of(1,2))).isEqualTo(ListNode.of(2))

    }

    fun middleNode(head: ListNode?): ListNode? {
        var slow = head
        var fast = head
        while (fast?.next != null) {
            slow = slow?.next
            fast = fast?.next?.next
        }
        return slow
    }
}
