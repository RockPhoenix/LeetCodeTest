import common.TreeNode

/**
 * 给定一个二叉树，我们在树的节点上安装摄像头。
 *
 * 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。
 *
 * 计算监控树的所有节点所需的最小摄像头数量
 *
 */
class MinCameraCover {

    //摄像头数量
    var cameraNum = 0

    fun minCameraCover(root: TreeNode?): Int {
        //如果根节点为空返回0
        if (root == null) return 0
        //如果递归返回未监控,说明root节点需要加一个相机
        if (dfs(root) == 1) cameraNum++
        return cameraNum
    }

    /**
     * return 1未监控,2已覆盖监控,3已安装监控
     */
    private fun dfs(root: TreeNode?): Int {
        if (root == null) return 1
        val left = dfs(root.left)
        val right = dfs(root.right)
        if (left == 1 || right == 1) {
            cameraNum++
            return 3
        }
        //只要子节点有一个没被监控,那么该节点就必须安装监控,否则说明该节点未监控
        return if (left == 3 || right == 3) 2 else 1
    }

}