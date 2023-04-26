package shane.leetcode.problems.easy

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

/**
 * Runtime 145 ms Beats 61.2%
 * Memory 33.4 MB Beats 69.49%
 */
class Q258AddDigitsK2 {

    @Test
    fun test() {
        assertThat(addDigits(38)).isEqualTo(2)
        assertThat(addDigits(100)).isEqualTo(1)
        assertThat(addDigits(0)).isEqualTo(0)
        assertThat(addDigits(10)).isEqualTo(1)
        assertThat(addDigits(99)).isEqualTo(9)
    }

    fun addDigits(num: Int): Int {
        var n = num
        while(10 <= n) {
            var sum = 0
            while(0 < n) {
                sum += n % 10
                n /= 10
            }
            n = sum
        }
        return n
    }


}
