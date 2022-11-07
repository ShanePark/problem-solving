package shane.leetcode.problems.easy

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

/**
 * Runtime 226 ms Beats 73.33%
 * Memory 33.3 MB Beats 93.33%
 */
class Q1323Maximum69NumberK {

    @Test
    fun test() {
        Assertions.assertThat(maximum69Number(9669)).isEqualTo(9969)
        Assertions.assertThat(maximum69Number(9996)).isEqualTo(9999)
        Assertions.assertThat(maximum69Number(9999)).isEqualTo(9999)
    }

    fun maximum69Number(num: Int): Int {
        val arr = num.toString().toCharArray()
        for (i in arr.indices) {
            if (arr[i] == '6') {
                return num + 3 * Math.pow(10.0, (arr.size.toDouble() - i - 1)).toInt()
            }
        }
        return num
    }

}
