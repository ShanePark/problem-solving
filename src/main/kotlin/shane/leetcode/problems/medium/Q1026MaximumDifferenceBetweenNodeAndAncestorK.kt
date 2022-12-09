package shane.leetcode.problems.medium

import com.tistory.shanepark.leetcode.TreeNode
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

/**
 * Runtime 249 ms Beats 82.14%
 * Memory 35.8 MB Beats 64.29%
 */
class Q1026MaximumDifferenceBetweenNodeAndAncestorK {

    @Test
    fun test() {
        Assertions.assertThat(maxAncestorDiff(TreeNode.of(8, 3, 10, 1, 6, null, 14, null, null, 4, 7, null, null, 13)))
            .isEqualTo(7)
        Assertions.assertThat(
            maxAncestorDiff(
                TreeNode.of(1, null, 2, null, null, null, 0, null, null, null, null, null, null, 3)
            )
        ).isEqualTo(3)
    }

    fun maxAncestorDiff(root: TreeNode?): Int {
        return maxAncestorDiff(root!!, root.`val`, root.`val`, 0);
    }

    fun maxAncestorDiff(node: TreeNode?, min: Int, max: Int, curMax: Int): Int {
        node?.let {
            val newMin = min(min, node.`val`)
            val newMax = max(max, node.`val`)
            val curDiff = max(abs(max - node.`val`), abs(min - node.`val`))
            val left = maxAncestorDiff(node.left, newMin, newMax, curMax)
            val right = maxAncestorDiff(node.right, newMin, newMax, curMax)
            return max(max(left, right), max(curDiff, curMax))
        }
        return curMax
    }
}
