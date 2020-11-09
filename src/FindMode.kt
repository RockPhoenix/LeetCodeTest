import common.TreeNode
import kotlin.collections.HashMap

/**
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 * 假定 BST 有如下定义：
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * 例如：
 * 给定 BST [1,null,2,2],
 * 1
 *  \
 *   2
 *  /
 * 2
 *
 * 返回[2].
 *
 * 提示：如果众数超过1个，不需考虑输出顺序
 *
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 */
class FindMode {
    fun findMode(root: TreeNode?): IntArray {
        var result = intArrayOf()
        val map = HashMap<Int, Int>()
        recursion(root, map)
        val sortMap = map.toList().sortedByDescending { it.second }.toMap()
        for ((i, entry) in sortMap.entries.withIndex()) {
            println(entry)
            result = when {
                i == 0 -> {
                    result.plus(entry.key)
                }
                entry.value == sortMap.entries.elementAt(i - 1).value -> {
                    result.plus(entry.key)
                }
                else -> {
                    return result
                }
            }
        }
        return result
    }

    private fun recursion(root: TreeNode?, map: HashMap<Int, Int>) {
        if (root == null) return
        val key = root.`val`
        var value = map[key] ?: 0
        map[key] = ++value
        recursion(root.left, map)
        recursion(root.right, map)
    }
}