package shane.leetcode.problems.medium

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.function.Consumer

/**
 * Runtime: 258 ms, faster than 56.41% of Kotlin online submissions for Custom Sort String.
 * Memory Usage: 34.5 MB, less than 76.92% of Kotlin online submissions for Custom Sort String.
 */
class Q791CustomSortString {

    @Test
    fun test() {
        assertThat(customSortString("cba", "abcd")).isEqualTo("cbad")
        assertThat(customSortString("cbafg", "abcd")).isEqualTo("cbad")
    }

    fun customSortString(order: String, s: String): String {
        val map: HashMap<Char, Int> = HashMap()
        for (c in s) {
            map.merge(c, 1, Integer::sum)
        }
        val sb: StringBuilder = StringBuilder()
        for (c in order) {
            for (i in 1..map.getOrDefault(c, 0)) {
                sb.append(c)
            }
            map.remove(c)
        }
        map.entries.forEach(Consumer { e ->
            run {
                for (i in 1..map.getOrDefault(e.key, 0)) {
                    sb.append(e.key)
                }
            }
        })
        return sb.toString()
    }
}
