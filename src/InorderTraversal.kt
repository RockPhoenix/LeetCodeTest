/**
 * 给定一个二叉树，返回它的中序遍历。
 * 示例:
 * 输入: [1,null,2,3]
 *  1
 *   \
 *    2
 *   /
 *  3
 *
 * 输出: [1,3,2]
 *
 * Example:
 * var ti = common.TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class common.TreeNode(var `val`: Int) {
 *     var left: common.TreeNode? = null
 *     var right: common.TreeNode? = null
 * }
 */
class InorderTraversal {
    private lateinit var result : MutableList<Int>
    fun inorderTraversal(root: TreeNode?): List<Int> {
        result = mutableListOf()
        dfs(root)
        return result
    }

    private fun dfs(root: TreeNode?){
        if (root?.left == null && root?.right == null){
            root?.`val`?.let { result.add(it) }
            return
        }else{
            dfs(root.left)
            result.add(root.`val`)
            dfs(root.right)
        }
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

}