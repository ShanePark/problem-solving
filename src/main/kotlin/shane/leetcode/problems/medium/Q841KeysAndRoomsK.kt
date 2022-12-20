package shane.leetcode.problems.medium

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

/**
 * Runtime 337 ms Beats 51.22%
 * Memory 45 MB Beats 21.95%
 */
class Q841KeysAndRoomsK {

    @Test
    fun test() {
        Assertions.assertThat(canVisitAllRooms(listOf(listOf(1), listOf(2), listOf(3), listOf()))).isTrue
        Assertions.assertThat(canVisitAllRooms(listOf(listOf(1, 3), listOf(3, 0, 1), listOf(2), listOf(0)))).isFalse
    }

    fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
        val set = HashSet<Int>()
        set.add(0)
        for (key in rooms[0]) {
            addKeys(rooms, key, set)
        }
        return set.size == rooms.size
    }

    private fun addKeys(rooms: List<List<Int>>, key: Int, set: HashSet<Int>) {
        if (set.add(key)) {
            val keys = rooms[key]
            for (next in keys) {
                addKeys(rooms, next, set)
            }
        }
    }

}
