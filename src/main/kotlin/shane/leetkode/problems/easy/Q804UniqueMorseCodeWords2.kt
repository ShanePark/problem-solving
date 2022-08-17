package shane.leetkode.problems.easy

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

/**
 * Runtime: 275 ms, faster than 23.81% of Kotlin online submissions for Unique Morse Code Words.
 * Memory Usage: 37.8 MB, less than 33.33% of Kotlin online submissions for Unique Morse Code Words.
 */
class Q804UniqueMorseCodeWords2 {

    @Test
    fun test() {
        Assertions.assertThat(uniqueMorseRepresentations(arrayOf("gin", "zen", "gig", "msg"))).isEqualTo(2)
    }

    fun uniqueMorseRepresentations(words: Array<String>): Int {
        val morse = arrayOf(
            ".-",
            "-...",
            "-.-.",
            "-..",
            ".",
            "..-.",
            "--.",
            "....",
            "..",
            ".---",
            "-.-",
            ".-..",
            "--",
            "-.",
            "---",
            ".--.",
            "--.-",
            ".-.",
            "...",
            "-",
            "..-",
            "...-",
            ".--",
            "-..-",
            "-.--",
            "--.."
        )
        return words.map { s ->
            s.map { c -> morse[c - 'a'] }.joinToString(separator = "")
        }.toCollection(hashSetOf()).size
    }

}
