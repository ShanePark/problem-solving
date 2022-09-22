package shane.leetcode.problems.easy

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

/**
 * Runtime: 421 ms, faster than 36.00% of Kotlin online submissions for Find Common Characters.
Memory Usage: 39.4 MB, less than 48.00% of Kotlin online submissions for Find Common Characters.

 */
class Q1002FindCommonCharacters {

    @Test
    fun test() {
        Assertions.assertThat(
            commonChars(
                arrayOf(
                    "acabcddd",
                    "bcbdbcbd",
                    "baddbadb",
                    "cbdddcac",
                    "aacbcccd",
                    "ccccddda",
                    "cababaab",
                    "addcaccd"
                )
            )
        ).isEmpty()
        Assertions.assertThat(commonChars(arrayOf("bella", "label", "roller"))).containsExactlyInAnyOrder("e", "l", "l")
        Assertions.assertThat(commonChars(arrayOf("cool", "lock", "cook"))).containsExactlyInAnyOrder("c", "o")
    }

    fun commonChars(words: Array<String>): List<String> {
        val arr = Array(words.size) { IntArray(26) }
        for (i in words.indices) {
            for (c in words[i]) {
                arr[i][c - 'a']++
            }
        }

        val answer = mutableListOf<String>()
        for (i in 0..25) {
            var min = 100
            for (j in words.indices) {
                min = minOf(min, arr[j][i])
            }
            for (j in 0 until min) {
                answer.add(('a' + i).toString())
            }
        }
        return answer
    }

}
