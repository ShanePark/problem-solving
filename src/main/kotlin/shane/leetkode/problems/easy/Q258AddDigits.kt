package shane.leetkode.problems.easy

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class Q258AddDigits {

    @Test
    fun test() {
        assertThat(addDigits(38)).isEqualTo(2)
        assertThat(addDigits(100)).isEqualTo(1)
        assertThat(addDigits(0)).isEqualTo(0)
        assertThat(addDigits(10)).isEqualTo(1)
        assertThat(addDigits(99)).isEqualTo(9)
    }

    fun addDigits(num: Int): Int {
        var num = num
        while (num >= 10) {
            var temp = num
            num = 0
            while (temp > 0) {
                num += temp % 10
                temp /= 10
            }
        }
        return num

    }


}
