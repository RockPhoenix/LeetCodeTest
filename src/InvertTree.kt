class InvertTree {

    /**
     * Example:
     * var ti = common.TreeNode(5)
     * var v = ti.`val`
     * Definition for a binary tree node.
     * class common.TreeNode(var `val`: Int) {
     *     var left: common.TreeNode? = null
     *     var right: common.TreeNode? = null
     * }
     */
    fun invertTree(root: TreeNode?): TreeNode? {
        if (root == null) return root
        val left = root.left
        root.left = root.right
        root.right = left
        invertTree(root.left)
        invertTree(root.right)
        return root
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

}