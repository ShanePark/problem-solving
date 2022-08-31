package shane.leetkode.problems.easy

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

/**
 * Runtime: 231 ms, faster than 54.17% of Kotlin online submissions for Minimum Value to Get Positive Step by Step Sum.
 * Memory Usage: 34.3 MB, less than 45.83% of Kotlin online submissions for Minimum Value to Get Positive Step by Step Sum.
 */
class Q1413MinimumValueToGetPositiveStepByStepSum {

    @Test
    fun test() {
        Assertions.assertThat(minStartValue(intArrayOf(-3, 2, -3, 4, 2))).isEqualTo(5)
        Assertions.assertThat(minStartValue(intArrayOf(1, 2))).isEqualTo(1)
        Assertions.assertThat(minStartValue(intArrayOf(-1))).isEqualTo(2)
        Assertions.assertThat(minStartValue(intArrayOf(0))).isEqualTo(1)
    }

    fun minStartValue(nums: IntArray): Int {
        var n = 0
        var min = 0
        for (num in nums) {
            n += num
            min = min.coerceAtMost(n)
        }
        return if (min > 0) {
            1
        } else {
            -min + 1
        }
    }
}
