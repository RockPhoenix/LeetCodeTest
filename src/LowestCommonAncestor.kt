import common.TreeNode

/**
 * 给定一个二叉搜索树/二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 *
 *
 * 示例 1:
 *
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 * 示例 2:
 *
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * 输出: 2
 * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 *  
 *
 * 说明:
 *
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉搜索树/二叉树中。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class LowestCommonAncestor {

    /**
     * 二叉搜索树
     */
    fun lowestCommonAncestorBST(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        //根据BST的特性,左节点<根节点<右节点
        //如果root同时大于p,q,则说明pq的LCA一定在root的左子树
        if (root?.`val`!! > p?.`val`!! && root.`val` > q?.`val`!!) return lowestCommonAncestorBST(root.left, p, q)
        //如果root同时小于p,q,则说明pq的LCA一定在root的右子树
        if (root.`val` < p.`val` && root.`val` < q?.`val`!!) return lowestCommonAncestorBST(root.right, p, q)
        //排除两种情况则说明root是pq的分叉点或者节点是自己本身的LCA
        return root
    }

    /**
     * 二叉树
     */
//    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
//
//    }

}