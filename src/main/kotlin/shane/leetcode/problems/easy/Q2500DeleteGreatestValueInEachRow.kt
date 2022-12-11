package shane.leetcode.problems.easy

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*

/**
 * Runtime 249 ms Beats 100%
 * Memory 38.9 MB Beats 100%
 */
class Q2500DeleteGreatestValueInEachRow {

    @Test
    fun test() {
        Assertions.assertThat(deleteGreatestValue(arrayOf(intArrayOf(1, 2, 4), intArrayOf(3, 3, 1)))).isEqualTo(8)
    }

    fun deleteGreatestValue(grid: Array<IntArray>): Int {
        val queues = grid.map {
            val pq = PriorityQueue(kotlin.Comparator<Int> { o1, o2 -> o2 - o1 })
            pq.addAll(it.asList())
            pq
        }.toList()
        var sum = 0
        val width = grid[0].size
        for (i in 0 until width) {
            var max = 1
            for (queue in queues) {
                max = max.coerceAtLeast(queue.poll());
            }
            sum += max;
        }
        return sum
    }
}
