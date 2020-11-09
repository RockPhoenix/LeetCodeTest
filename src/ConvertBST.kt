/**
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 */
class ConvertBST {

    fun convertBST(root: TreeNode?): TreeNode? {
        greaterTree(root, 0)
        return root
    }

    private fun greaterTree(root: TreeNode?, lastValue: Int) {
        if (root?.`val` == null) return
        greaterTree(root.right,lastValue)
        root.`val` += lastValue
        greaterTree(root.left,lastValue)
    }

    inner class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

}