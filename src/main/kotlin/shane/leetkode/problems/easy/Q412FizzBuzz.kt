package shane.leetkode.problems.easy

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

/**
 * Runtime: 184 ms, faster than 97.23% of Kotlin online submissions for Fizz Buzz.
 * Memory Usage: 36.6 MB, less than 92.34% of Kotlin online submissions for Fizz Buzz.
 */
class Q412FizzBuzz {

    @Test
    fun test() {
        assertThat(fizzBuzz(3)).containsExactly("1", "2", "Fizz");
        assertThat(fizzBuzz(5)).containsExactly("1", "2", "Fizz", "4", "Buzz");
        assertThat(fizzBuzz(15)).containsExactly("1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz");
    }

    fun fizzBuzz(n: Int): List<String> {
        val list = mutableListOf<String>()
        for (i in 1..n) {
            if (i % 15 == 0) {
                list.add("FizzBuzz")
            } else if (i % 3 == 0) {
                list.add("Fizz")
            } else if (i % 5 == 0) {
                list.add("Buzz")
            } else {
                list.add(i.toString())
            }
        }
        return list
    }
}
