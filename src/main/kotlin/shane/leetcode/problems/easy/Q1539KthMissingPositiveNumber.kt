package shane.leetcode.problems.easy

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

/**
 * Runtime 173 ms Beats 89.47%
 * Memory 37.2 MB Beats 31.58%
 */
class Q1539KthMissingPositiveNumber {

    @Test
    fun test() {
        Assertions.assertThat(findKthPositive(intArrayOf(2, 3, 4, 7, 11), 5)).isEqualTo(9)
        Assertions.assertThat(findKthPositive(intArrayOf(1, 2, 3, 4), 2)).isEqualTo(6)
        Assertions.assertThat(findKthPositive(intArrayOf(), 1)).isEqualTo(1)
    }

    fun findKthPositive(arr: IntArray, k: Int): Int {
        var beforeNum = 0
        var cnt = k
        for (n in arr) {
            cnt -= (n - beforeNum - 1)
            if (cnt <= 0)
                return n + cnt - 1
            beforeNum = n
        }
        return (arr.lastOrNull() ?: 0) + cnt
    }

}
