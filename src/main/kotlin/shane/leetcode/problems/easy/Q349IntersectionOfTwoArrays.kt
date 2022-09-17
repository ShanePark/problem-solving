package shane.leetcode.problems.easy

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

/**
 * Runtime: 455 ms, faster than 5.13% of Kotlin online submissions for Intersection of Two Arrays.
Memory Usage: 42.1 MB, less than 20.51% of Kotlin online submissions for Intersection of Two Arrays.
 */
class Q349IntersectionOfTwoArrays {

    @Test
    fun test() {
        Assertions.assertThat(intersection(intArrayOf(1, 2, 2, 1), intArrayOf(2, 2))).containsExactlyInAnyOrder(2)
        Assertions.assertThat(intersection(intArrayOf(4, 9, 5), intArrayOf(9, 4, 9, 8, 4)))
            .containsExactlyInAnyOrder(4, 9)
    }

    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
        return nums1.toSet().intersect(nums2.toSet()).toIntArray()
    }
}
