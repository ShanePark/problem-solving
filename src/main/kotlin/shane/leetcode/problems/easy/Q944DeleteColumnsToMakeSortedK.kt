package shane.leetcode.problems.easy

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

/**
 * Runtime 408 ms Beats 43.75%
 * Memory 48.6 MB Beats 37.50%
 */
class Q944DeleteColumnsToMakeSortedK {

    @Test
    fun test() {
        Assertions.assertThat(minDeletionSize(arrayOf("cba", "daf", "ghi"))).isEqualTo(1)
        Assertions.assertThat(minDeletionSize(arrayOf("a", "b"))).isEqualTo(0)
        Assertions.assertThat(minDeletionSize(arrayOf("zyx", "wvu", "tsr"))).isEqualTo(3)
    }

    fun minDeletionSize(strs: Array<String>): Int {
        val height = strs.size
        val width = strs[0].length
        var cnt = 0
        for (j in 0 until width) {
            for (i in 1 until height) {
                if (strs[i - 1][j] > strs[i][j]) {
                    cnt++
                    break
                }
            }
        }
        return cnt
    }
}
