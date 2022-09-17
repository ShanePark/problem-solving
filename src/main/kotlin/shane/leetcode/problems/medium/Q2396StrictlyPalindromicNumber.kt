package shane.leetcode.problems.medium

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

/**
 * Runtime: 215 ms, faster than 100.00% of Kotlin online submissions for Strictly Palindromic Number.
Memory Usage: 33.3 MB, less than 100.00% of Kotlin online submissions for Strictly Palindromic Number.
 */
class Q2396StrictlyPalindromicNumber {

    @Test
    fun test() {
        assertThat(base(4, 2)).isEqualTo("100")
        assertThat(isStrictlyPalindromic(4)).isFalse
        assertThat(isStrictlyPalindromic(9)).isFalse
        assertThat(base(1023, 2)).isEqualTo("1111111111")

    }

    fun isStrictlyPalindromic(n: Int): Boolean {
        for (d in 2..n - 2) {
            val str = base(n, d)
            val length = str.length
            for (i in 0 until length / 2) {
                if (str[i] != str[length - i - 1])
                    return false
            }
        }
        return true
    }

    private fun base(n: Int, d: Int): String {
        var sb = StringBuilder()
        var num = n
        while (num >= 1) {
            sb.insert(0, num % d)
            num /= d
        }
        return sb.toString()
    }

}
