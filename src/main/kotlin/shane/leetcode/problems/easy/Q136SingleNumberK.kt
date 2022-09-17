package shane.leetcode.problems.easy

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class Q136SingleNumberK {

    @Test
    fun test() {
        Assertions.assertThat(singleNumber(intArrayOf(2, 2, 1))).isEqualTo(1)
        Assertions.assertThat(singleNumber(intArrayOf(4, 1, 2, 1, 2))).isEqualTo(4)
        Assertions.assertThat(singleNumber(intArrayOf(1))).isEqualTo(1)

    }

    fun singleNumber(nums: IntArray): Int {
        val set = mutableSetOf<Int>()
        for (num in nums) {
            if (!set.add(num)) {
                set.remove(num)
            }
        }
        return set.stream().findAny().get()
    }
}
