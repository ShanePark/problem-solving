package shane.leetcode.problems.easy

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

/**
 * Runtime 189 ms Beats 98.46%
 * Memory 37.2 MB Beats 80%
 */
class Q1470ShuffleTheArrayK {

    @Test
    fun test() {
        Assertions.assertThat(shuffle(intArrayOf(2, 5, 1, 3, 4, 7), 3)).isEqualTo(intArrayOf(2, 3, 5, 4, 1, 7))
        Assertions.assertThat(shuffle(intArrayOf(1, 2, 3, 4, 4, 3, 2, 1), 4))
            .isEqualTo(intArrayOf(1, 4, 2, 3, 3, 2, 4, 1))
        Assertions.assertThat(shuffle(intArrayOf(1, 1, 2, 2), 2)).isEqualTo(intArrayOf(1, 2, 1, 2))
    }

    fun shuffle(nums: IntArray, n: Int): IntArray {
        val arr = IntArray(n * 2) { 0 }

        for (i in 0 until n) {
            arr[2 * i] = nums[i]
            arr[2 * i + 1] = nums[n + i]
        }
        return arr
    }

}
