package shane.leetcode.problems.easy

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

/**
 * Runtime: 295 ms, faster than 27.27% of Kotlin online submissions for Substrings of Size Three with Distinct Characters.
 * Memory Usage: 35.4 MB, less than 54.55% of Kotlin online submissions for Substrings of Size Three with Distinct Characters.
 */
class Q1876SubstringsOfSizeThreeWithDistinctCharactersK {

    @Test
    fun test() {
        Assertions.assertThat(countGoodSubstrings("aababcabc")).isEqualTo(4)
        Assertions.assertThat(countGoodSubstrings("xyzzaz")).isEqualTo(1)

    }

    fun countGoodSubstrings(s: String): Int {
        if (s.length < 3)
            return 0

        val exceedMap = HashMap<Char, Int>()
        val set = HashSet<Char>()

        for (i in 0..2) {
            if (!set.add(s[i])) {
                exceedMap.merge(s[i], 1, Integer::sum)
            }
        }

        var cnt = if (exceedMap.isEmpty()) 1 else 0

        for (i in 3 until s.length) {
            val before = s[i - 3]
            if (exceedMap[before] == null) {
                set.remove(before)
            } else if (exceedMap[before] == 1) {
                exceedMap.remove(before)
            } else {
                exceedMap.merge(before, -1, Integer::sum)
            }
            if (!set.add(s[i])) {
                exceedMap.merge(s[i], 1, Integer::sum)
            }
            if (exceedMap.isEmpty())
                cnt++
        }
        return cnt
    }

}
