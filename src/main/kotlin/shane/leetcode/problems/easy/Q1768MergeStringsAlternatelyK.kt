package shane.leetcode.problems.easy

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

/**
 * Runtime 138 ms Beats 96.55%
 * Memory 34.4 MB Beats 75.86%
 */
class Q1768MergeStringsAlternatelyK {

    @Test
    fun test() {
        Assertions.assertThat(mergeAlternately("abc", "pqr")).isEqualTo("apbqcr")
        Assertions.assertThat(mergeAlternately("ab", "pqrs")).isEqualTo("apbqrs")
        Assertions.assertThat(mergeAlternately("abcd", "pq")).isEqualTo("apbqcd")
    }

    fun mergeAlternately(word1: String, word2: String): String {
        val minLength = Math.min(word1.length, word2.length)
        val sb = StringBuilder()
        for (i in 0 until minLength) {
            sb.append(word1[i])
            sb.append(word2[i])
        }

        return sb.append(word1.substring(minLength))
            .append(word2.substring(minLength))
            .toString()
    }

}
