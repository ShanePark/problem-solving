package shane.leetcode.problems.easy

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

/**
 * Runtime: 491 ms, faster than 35.32% of Kotlin online submissions for Reverse Words in a String III.
Memory Usage: 58.1 MB, less than 30.43% of Kotlin online submissions for Reverse Words in a String III.
 */
class Q557ReverseWordsInAStringIIIK {

    @Test
    fun test() {
        assertThat(reverseWords("Let's take LeetCode contest")).isEqualTo("s'teL ekat edoCteeL tsetnoc")
        assertThat(reverseWords("God Ding")).isEqualTo("doG gniD")
        assertThat(reverseWords("a")).isEqualTo("a")
    }

    fun reverseWords(s: String): String {
        return s
            .split(" ")
            .joinToString(" ") { it.reversed() }
    }
}
