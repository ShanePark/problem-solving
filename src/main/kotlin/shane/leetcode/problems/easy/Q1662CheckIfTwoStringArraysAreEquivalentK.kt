package shane.leetcode.problems.easy

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

/**
 * Runtime: 295 ms, faster than 48.98% of Kotlin online submissions for Check If Two String Arrays are Equivalent.
 * Memory Usage: 38 MB, less than 53.06% of Kotlin online submissions for Check If Two String Arrays are Equivalent.
 */
class Q1662CheckIfTwoStringArraysAreEquivalentK {

    @Test
    fun test() {
        Assertions.assertThat(arrayStringsAreEqual(arrayOf("ab", "c"), arrayOf("a", "bc"))).isTrue
        Assertions.assertThat(arrayStringsAreEqual(arrayOf("a", "cb"), arrayOf("ab", "c"))).isFalse
        Assertions.assertThat(arrayStringsAreEqual(arrayOf("abc", "d", "defg"), arrayOf("abcddefg"))).isTrue
    }

    fun arrayStringsAreEqual(word1: Array<String>, word2: Array<String>): Boolean {
        return word1.flatMap { s -> s.asIterable() } == word2.flatMap { s -> s.asIterable() }
    }
}
