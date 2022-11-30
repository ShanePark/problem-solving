package shane.leetcode.problems.easy

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

/**
 * Runtime 308 ms Beats 39.47%
 * Memory 36.6 MB Beats 15.79%
 */
class Q1207UniqueNumberOfOccurrencesK {

    @Test
    fun test() {
        Assertions.assertThat(uniqueOccurrences(intArrayOf(1, 2, 2, 1, 1, 3))).isTrue
        Assertions.assertThat(uniqueOccurrences(intArrayOf(1, 2))).isFalse
        Assertions.assertThat(uniqueOccurrences(intArrayOf(-3, 0, 1, -3, 1, 1, 1, -3, 10, 0))).isTrue
    }

    fun uniqueOccurrences(arr: IntArray): Boolean {
        val map = HashMap<Int, Int>()
        arr.forEach { map.merge(it, 1, Integer::sum) }
        return map.values.distinct().size == map.size
    }
}
