package shane.leetkode.problems.easy

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

/**
 * Runtime: 277 ms, faster than 81.32% of Kotlin online submissions for Shuffle String.
 * Memory Usage: 38 MB, less than 94.51% of Kotlin online submissions for Shuffle String.
 */
class Q1528ShuffleString {

    @Test
    fun test() {
        Assertions.assertThat(restoreString("codeleet", intArrayOf(4, 5, 6, 7, 0, 2, 1, 3))).isEqualTo("leetcode")
    }

    fun restoreString(s: String, indices: IntArray): String {
        val arr = CharArray(s.length)
        for (i in s.indices) {
            arr[indices[i]] = s[i]
        }
        return String(arr)
    }
}
