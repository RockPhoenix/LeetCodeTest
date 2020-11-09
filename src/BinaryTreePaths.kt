import java.lang.StringBuilder

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例:
 * 输入:
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class BinaryTreePaths {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val root = TreeNode(1)
            val node2 = TreeNode(2)
            val node3 = TreeNode(3)
            val node5 = TreeNode(5)
            root.left = node2
            root.right = node3
            node2.right = node5
            val instance = BinaryTreePaths()
            println(instance.binaryTreePaths(root))
        }
    }

    fun binaryTreePaths(root: TreeNode?): List<String> {
        if (root == null) return emptyList()
        val result: MutableList<String> = ArrayList()
        dfs(StringBuilder(), root, result)
        return result
    }

    private fun dfs(path: StringBuilder, node: TreeNode?, result: MutableList<String>) {
        if (node == null) return
        val stringBuilder = StringBuilder(path.toString())
        stringBuilder.append(node.v.toString())
        println(stringBuilder)
        //当左右子树都为空时判断为叶子节点
        if (node.left == null && node.right == null) {
            result.add(stringBuilder.toString())
            return
        } else {
            stringBuilder.append("->")
            dfs(stringBuilder, node.left, result)
            dfs(stringBuilder, node.right, result)
        }
    }

    class TreeNode(var v: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

}