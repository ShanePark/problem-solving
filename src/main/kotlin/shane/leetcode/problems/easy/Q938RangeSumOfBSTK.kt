package shane.leetcode.problems.easy

import com.tistory.shanepark.leetcode.TreeNode
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

/**
 * Runtime 639 ms Beats 70.67%
 * Memory 71.4 MB Beats 65.33%
 */
class Q938RangeSumOfBSTK {

    @Test
    fun test() {
        Assertions.assertThat(rangeSumBST(TreeNode.of(10, 5, 15, 3, 7, null, 18), 7, 15)).isEqualTo(32)
        Assertions.assertThat(rangeSumBST(TreeNode.of(10, 5, 15, 3, 7, 13, 18, 1, null, 6), 6, 10)).isEqualTo(23)
    }

    fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
        root?.let {
            if (root.`val` < low) {
                return rangeSumBST(root.right, low, high)
            } else if (root.`val` <= high) {
                return rangeSumBST(root.left, low, high) + root.`val` + rangeSumBST(root.right, low, high)
            } else {
                return rangeSumBST(root.left, low, high)
            }
        }
        return 0
    }
}
