package shane.leetcode.problems.easy

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

/**
 * Runtime: 341 ms, faster than 9.80% of Kotlin online submissions for Check if the Sentence Is Pangram.
 * Memory Usage: 36.7 MB, less than 27.45% of Kotlin online submissions for Check if the Sentence Is Pangram.
 */
class Q1832CheckIfTheSentenceIsPangramK {
    @Test
    fun test() {
        Assertions.assertThat(checkIfPangram("thequickbrownfoxjumpsoverthelazydog")).isTrue
        Assertions.assertThat(checkIfPangram("leetcode")).isFalse
    }

    fun checkIfPangram(sentence: String): Boolean {
        return sentence.chars().distinct().count() == 26L
    }
}
