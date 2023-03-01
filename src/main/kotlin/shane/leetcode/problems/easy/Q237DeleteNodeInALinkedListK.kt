package shane.leetcode.problems.easy

import io.github.shanepark.leetcode.ListNode
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class Q237DeleteNodeInALinkedListK {

    @Test
    fun test() {
        val node = ListNode.of(4, 5, 1, 9)
        deleteNode(node.next)
        Assertions.assertThat(node).isEqualTo(ListNode.of(4, 1, 9))

    }

    fun deleteNode(node: ListNode) {
        node.`val` = node.next.`val`
        node.next = node.next.next
    }
}
