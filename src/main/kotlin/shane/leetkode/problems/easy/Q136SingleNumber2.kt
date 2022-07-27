package shane.leetkode.problems.easy

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class Q136SingleNumber2 {

    @Test
    fun test() {
        Assertions.assertThat(singleNumber(intArrayOf(2, 2, 1))).isEqualTo(1)
        Assertions.assertThat(singleNumber(intArrayOf(4, 1, 2, 1, 2))).isEqualTo(4)
        Assertions.assertThat(singleNumber(intArrayOf(1))).isEqualTo(1)

    }

    fun singleNumber(nums: IntArray): Int {
        var n = 0
        for (num in nums) {
            n = n xor num
        }
        return n
    }
}
