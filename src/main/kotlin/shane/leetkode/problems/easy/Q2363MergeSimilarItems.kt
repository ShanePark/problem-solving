package shane.leetkode.problems.easy

import com.tistory.shanepark.STool
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

/**
 * Runtime: 603 ms, faster than 100.00% of Kotlin online submissions for Merge Similar Items.
 * Memory Usage: 74 MB, less than 100.00% of Kotlin online submissions for Merge Similar Items.
 */
class Q2363MergeSimilarItems {

    @Test
    fun test() {
        Assertions.assertThat(
            mergeSimilarItems(
                STool.convertToIntArray("[[1,1],[4,5],[3,8]]"),
                STool.convertToIntArray("[[3,1],[1,5]]")
            )
        ).isEqualTo(STool.convertToIntList("[[1,6],[3,9],[4,5]]"))
    }

    fun mergeSimilarItems(items1: Array<IntArray>, items2: Array<IntArray>): List<List<Int>> {
        val map = HashMap<Int, Int>()
        for (item in items1) {
            map.merge(item[0], item[1], Integer::sum)
        }
        for (item in items2) {
            map.merge(item[0], item[1], Integer::sum)
        }
        return map.entries.sortedBy { e -> e.key }.map { e -> listOf(e.key, e.value) }
    }
}
