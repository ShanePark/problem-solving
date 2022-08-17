package shane.leetkode.problems.easy

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

/**
 * Runtime: 190 ms, faster than 95.24% of Kotlin online submissions for Unique Morse Code Words.
Memory Usage: 35.2 MB, less than 71.43% of Kotlin online submissions for Unique Morse Code Words.
 */
class Q804UniqueMorseCodeWords {

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
            val sb = StringBuilder()
            for (c in s) {
                sb.append(morse[c - 'a'])
            }
            sb.toString()
        }.toCollection(hashSetOf()).size
    }

}
