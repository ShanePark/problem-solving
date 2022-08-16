package shane.leetkode.problems.easy

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

/**
 * Runtime: 497 ms, faster than 44.40% of Kotlin online submissions for First Unique Character in a String.
 * Memory Usage: 67.3 MB, less than 10.35% of Kotlin online submissions for First Unique Character in a String.
 */
class Q387FirstUniqueCharacterInAString2 {

    @Test
    fun test() {
        Assertions.assertThat(firstUniqChar("aabb")).isEqualTo(-1)
        Assertions.assertThat(firstUniqChar("leetcode")).isEqualTo(0)
        Assertions.assertThat(firstUniqChar("loveleetcode")).isEqualTo(2)
    }

    fun firstUniqChar(s: String): Int {
        val countMap: LinkedHashMap<Char, Int> = LinkedHashMap()
        for (c in s) {
            countMap.merge(c, 1, Integer::sum)
        }
        for (entry in countMap) {
            if (entry.value == 1) {
                return s.indexOf(entry.key)
            }
        }
        return -1
    }
}
