package shane.leetcode.problems.easy

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

/**
 * Runtime 208 ms Beats 100%
 * Memory 36.7 MB Beats 66.67%
 */
class Q1704DetermineIfStringHalvesAreAlikeK {

    @Test
    fun test() {
        Assertions.assertThat(halvesAreAlike("book")).isTrue
        Assertions.assertThat(halvesAreAlike("textbook")).isFalse
    }

    fun halvesAreAlike(s: String): Boolean {
        val vowels = setOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
        val length = s.length
        var cnt = 0
        for (i in 0 until length / 2) {
            if (vowels.contains(s[i])) {
                cnt++
            } else {
                cnt--
            }
        }
        for (i in length / 2 until length) {
            if (vowels.contains(s[i])) {
                cnt--
            } else {
                cnt++
            }
        }
        return cnt == 0
    }
}
