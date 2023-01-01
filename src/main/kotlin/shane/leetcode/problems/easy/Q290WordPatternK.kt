package shane.leetcode.problems.easy

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

/**
 * Runtime 166 ms Beats 83.2%
 * Memory 35.7 MB Beats 84.91%
 */
class Q290WordPatternK {

    @Test
    fun test() {
        Assertions.assertThat(wordPattern("aaa", "aa aa aa aa")).isFalse
        Assertions.assertThat(wordPattern("abba", "dog cat cat dog")).isTrue
        Assertions.assertThat(wordPattern("abba", "dog cat cat fish")).isFalse
        Assertions.assertThat(wordPattern("aaaa", "dog cat cat dog")).isFalse
    }

    fun wordPattern(pattern: String, s: String): Boolean {
        val map = HashMap<String, Char>()
        val set = HashSet<Char>()
        val arr = s.split(" ")
        if (pattern.length != arr.size)
            return false
        for (i in pattern.indices) {
            val str = arr[i]
            val char = pattern[i]

            if (!map.containsKey(str)) {
                map[str] = char
                if (!set.add(char))
                    return false
            }
            if (map[str] != char)
                return false
        }
        return true
    }

}
