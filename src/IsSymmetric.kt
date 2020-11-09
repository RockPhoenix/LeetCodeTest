/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *           1
 *       /        \
 *      2          2
 *    /   \      /   \
 *   3     4    4     3
 *  / \   / \  / \   / \
 * 7  8  9  0 0  9  8   7
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *  1
 * / \
 * 2  2
 *  \  \
 *   3  3

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/symmetric-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class IsSymmetric {

    fun isSymmetric(root: TreeNode?): Boolean {
        if (root==null)return true
        return dfs(root.left,root.right)
    }

    private fun dfs(left: TreeNode?, right: TreeNode?): Boolean {
        if (left == null && right==null)return true
        if (left==null || right==null)return false
        if (left.`val` != right.`val`)return true
        return dfs(left.right, right.left) && dfs(left.left, right.right)
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

}