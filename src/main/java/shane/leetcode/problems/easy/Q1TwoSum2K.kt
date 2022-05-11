package shane.leetcode.problems.easy

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Q1TwoSum2K {

    @Test
    fun test() {
        assertThat(twoSum(intArrayOf(2, 7, 11, 15), 9)).containsExactly(0, 1)
        assertThat(twoSum(intArrayOf(3, 2, 4), 6)).containsExactly(1, 2)
        assertThat(twoSum(intArrayOf(3, 3), 6)).containsExactly(0, 1)
        assertThat(twoSum(intArrayOf(1, 1, 1, 1, 1, 4, 1, 1, 1, 1, 1, 7, 1, 1, 1, 1, 1), 11)).containsExactly(5, 11)
    }

    fun twoSum(nums: IntArray, target: Int): IntArray {
        var map = HashMap<Int, Int>()

        for (i in 0..nums.size) {
            map[target - nums[i]]?.let { it ->
                return intArrayOf(it, i)
            } ?: run {
                map[nums[i]] = i
            }
        }
        return intArrayOf(-1)
    }
}
