package shane.leetcode.problems.easy

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

/**
 * Runtime: 231 ms, faster than 33.33% of Kotlin online submissions for Smallest Even Multiple.
Memory Usage: 33.2 MB, less than 92.59% of Kotlin online submissions for Smallest Even Multiple.
 */
class Q2413SmallestEvenMultiple {

    @Test
    fun test() {
        Assertions.assertThat(smallestEvenMultiple(5)).isEqualTo(10)
        Assertions.assertThat(smallestEvenMultiple(6)).isEqualTo(6)
    }

    fun smallestEvenMultiple(n: Int): Int {
        return if (n % 2 == 0) n else n * 2
    }
}
