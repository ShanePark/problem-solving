package shane.leetkode.problems.easy

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

/**
 * working on IDE but not on leetcode.com
 *
 * Line 8: Char 14: error: unresolved reference: firstNotNullOfOrNull
 * .firstNotNullOfOrNull { e: Map.Entry<Char, Int>  -> e.key }
 * ^
 * Line 9: Char 21: error: cannot infer a type for this parameter. Please specify it explicitly.
 * ?.let { c ->
 * ^
 */
class Q387FirstUniqueCharacterInAString {

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
        return countMap.filter { e -> e.value < 2 }
            .firstNotNullOfOrNull { e -> e.key }
            ?.let { c ->
                s.indexOf(c)
            } ?: run {
            -1
        }
    }
}
