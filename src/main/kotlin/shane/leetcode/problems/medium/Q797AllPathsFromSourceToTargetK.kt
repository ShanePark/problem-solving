package shane.leetcode.problems.medium

import com.github.shanepark.Ps
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

/**
 * Runtime 295 ms Beats 96.36%
 * Memory 39.2 MB Beats 100%
 */
class Q797AllPathsFromSourceToTargetK {

    @Test
    fun test() {
        Assertions.assertThat(allPathsSourceTarget(Ps.intArray("[[1,2],[3],[3],[]]")))
            .containsAll(Ps.intList("[[0,1,3],[0,2,3]]"))
        Assertions.assertThat(allPathsSourceTarget(Ps.intArray("[[4,3,1],[3,2,4],[3],[4],[]]")))
            .containsAll(Ps.intList("[[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]"))
    }

    fun allPathsSourceTarget(graph: Array<IntArray>): List<List<Int>> {
        val map = mutableMapOf<Int, Node>()
        for (i in graph.indices) {
            for (j in graph[i]) {
                val node = map.getOrDefault(i, Node(i))
                val next = map.getOrDefault(j, Node(j))

                node.addNext(next)

                map[i] = node
                map[j] = next
            }
        }

        val visited = BooleanArray(graph.size)
        val answer = mutableListOf<List<Int>>()
        visited[0] = true

        dfs(map[0]!!, map.size - 1, mutableListOf(0), visited, answer)
        return answer
    }

    private fun dfs(
        node: Node,
        target: Int,
        list: MutableList<Int>,
        visited: BooleanArray,
        answer: MutableList<List<Int>>
    ) {
        if (node.index == target) {
            answer.add(list.toMutableList())
            return
        }

        for (next in node.next) {
            if (!visited[next.index]) {
                visited[next.index] = true
                list.add(next.index)

                dfs(next, target, list, visited, answer)

                visited[next.index] = false
                list.remove(next.index)
            }
        }

    }

    class Node(
        val index: Int
    ) {
        val next = mutableListOf<Node>()

        fun addNext(n: Node) {
            next.add(n)
        }
    }

}
