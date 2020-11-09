import common.TreeNode

class PostorderTraversal {

    fun postorderTraversal(root: TreeNode?): List<Int> {
        val result: MutableList<Int> = arrayListOf()
        dfs(result, root)
        return result
    }

    private fun dfs(result: MutableList<Int>, root: TreeNode?) {
        if (root == null) return
        dfs(result, root.left)
        dfs(result, root.right)
        result.add(root.`val`)
    }


}