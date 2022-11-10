package shane.leetcode.problems.easy

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*

/**
 * Runtime 650 ms Beats 50%
 * Memory 57.1 MB Beats 46.15%
 */
class Q1047RemoveAllAdjacentDuplicatesInStringK {

    @Test
    fun test() {
        Assertions.assertThat(removeDuplicates("abbaca")).isEqualTo("ca")
        Assertions.assertThat(removeDuplicates("azxxzy")).isEqualTo("ay")
    }

    fun removeDuplicates(s: String): String {
        val stack: Stack<Char> = Stack()
        for (c in s) {
            if(stack.isNotEmpty() && stack.peek() == c) {
                stack.pop()
            } else {
                stack.add(c)
            }
        }
        return stack.joinToString("")
    }

}
