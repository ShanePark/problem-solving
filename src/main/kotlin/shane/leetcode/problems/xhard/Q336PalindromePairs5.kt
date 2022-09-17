package shane.leetcode.problems.xhard

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

/**
 * code from https://leetcode.com/problems/palindrome-pairs/discuss/79195/O(n-*-k2)-java-solution-with-Trie-structure
 * Runtime: 3261 ms, faster than 42.86% of Kotlin online submissions for Palindrome Pairs.
 * Memory Usage: 323.9 MB, less than 28.57% of Kotlin online submissions for Palindrome Pairs.
 */
class Q336PalindromePairs5 {

    @Test
    fun tle() {
        Assertions.assertThat(palindromePairs(Q336PalindromePairs_TESTCASE1.testCase1)).hasSize(4869)
    }

    @Test
    fun tle2() {
        Assertions.assertThat(palindromePairs(Q336PalindromePairs_TESTCASE2.testCase2)).hasSize(56)
    }

    fun palindromePairs(words: Array<String>): List<List<Int>>? {
        val answer: MutableList<List<Int>> = ArrayList()
        val root = TrieNode()
        for (i in words.indices) {
            addWord(root, words[i], i)
        }
        for (i in words.indices) {
            search(words, i, root, answer)
        }
        return answer
    }

    private fun addWord(root: TrieNode, word: String, index: Int) {
        var root = root
        for (i in word.length - 1 downTo 0) {
            val j = word[i]
            if (root!!.next[j - 'a'] == null) {
                root.next[j - 'a'] = TrieNode()
            }
            if (isPalindrome(word, 0, i)) {
                root.list.add(index)
            }
            root = root.next[j - 'a']!!
        }
        root!!.list.add(index)
        root.index = index
    }

    private fun search(words: Array<String>, i: Int, root: TrieNode, answer: MutableList<List<Int>>) {
        var root: TrieNode? = root
        for (j in 0 until words[i].length) {
            if (root!!.index >= 0 && root.index != i && isPalindrome(words[i], j, words[i].length - 1)) {
                answer.add(listOf(i, root.index))
            }
            root = root.next[words[i][j] - 'a']
            if (root == null) return
        }
        for (j in root!!.list) {
            if (i == j) continue
            answer.add(listOf(i, j))
        }
    }

    private fun isPalindrome(word: String, i: Int, j: Int): Boolean {
        var i = i
        var j = j
        while (i < j) {
            if (word[i++] != word[j--]) return false
        }
        return true
    }

    private class TrieNode {
        var next = arrayOfNulls<TrieNode>(26)
        var index: Int = -1
        var list: MutableList<Int> = ArrayList()
    }

}
