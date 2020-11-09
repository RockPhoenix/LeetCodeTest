import java.util.*

class Solution {
    fun permuteUnique(nums: IntArray): List<List<Int>> {
        val len = nums.size
        val res: MutableList<List<Int>> = ArrayList()
        if (len == 0) {
            return res
        }

        // 排序（升序或者降序都可以），排序是剪枝的前提
        Arrays.sort(nums)
        val used = BooleanArray(len)
        // 使用 Deque 是 Java 官方 Stack 类的建议
        dfs(nums, len, 0, used, ArrayDeque(), res)
        return res
    }

    private fun dfs(nums: IntArray, len: Int, depth: Int, used: BooleanArray, path: Deque<Int>, res: MutableList<List<Int>>) {
        if (depth == len) {
            res.add(ArrayList(path))
            return
        }
        for (i in nums.indices) {
            if (used[i]) {
                continue
            }

            // 剪枝条件：i > 0 是为了保证 nums[i - 1] 有意义
            // 写 !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue
            }
            path.addLast(nums[i])
            used[i] = true
            dfs(nums, len, depth + 1, used, path, res)
            // 回溯部分的代码，和 dfs 之前的代码是对称的
            used[i] = false
            path.removeLast()
        }
    }
}