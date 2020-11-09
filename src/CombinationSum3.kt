/**
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。

说明：

所有数字都是正整数。
解集不能包含重复的组合。 
示例 1:

输入: k = 3, n = 7
输出: [[1,2,4]]
示例 2:

输入: k = 3, n = 9
输出: [[1,2,6], [1,3,5], [2,3,4]]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/combination-sum-iii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class CombinationSum3 {

    fun combinationSum3(k: Int, n: Int): List<List<Int>> {
        val result: ArrayList<ArrayList<Int>> = ArrayList()
        dfs(result, arrayListOf(), k, n, 1)
        return result
    }

    private fun dfs(result: ArrayList<ArrayList<Int>>, combineList: ArrayList<Int>, k: Int, n: Int, start: Int) {
        if (n < 0 || k < 0) return
        if (n == 0 && k == 0) {
            result.add(ArrayList(combineList))
        } else {
            for (i in start..9) {
                combineList.add(i)
                dfs(result, combineList, k - 1, n - i, i + 1)
                combineList.removeAt(combineList.size - 1)
            }
        }
    }

}