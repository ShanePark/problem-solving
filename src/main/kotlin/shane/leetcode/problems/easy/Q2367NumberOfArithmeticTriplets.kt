package shane.leetcode.problems.easy

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

/**
 * Runtime: 287 ms, faster than 100.00% of Kotlin online submissions for Number of Arithmetic Triplets.
 * Memory Usage: 37.1 MB, less than 100.00% of Kotlin online submissions for Number of Arithmetic Triplets.
 */
class Q2367NumberOfArithmeticTriplets {

    @Test
    fun test() {
        Assertions.assertThat(arithmeticTriplets(intArrayOf(0, 1, 4, 6, 7, 10), 3)).isEqualTo(2)
        Assertions.assertThat(arithmeticTriplets(intArrayOf(4, 5, 6, 7, 8, 9), 2)).isEqualTo(2)
    }

    fun arithmeticTriplets(nums: IntArray, diff: Int): Int {
        val set = nums.toSet()
        return nums.count { n ->
            set.contains(n + diff) && set.contains(n + diff + diff)
        }
    }
}
