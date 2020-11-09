import java.util.*
import kotlin.collections.ArrayList

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * 示例:
 * 输入: [1,1,2]
 * 输出:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 */
class PermuteUnique {

    fun permuteUnique(nums: IntArray): List<List<Int>> {
        Arrays.sort(nums)
        val result: MutableList<List<Int>> = arrayListOf()
        val used = BooleanArray(nums.size)
        traceBack(result, arrayListOf(), nums, 0, used)
        return result
    }

    private fun traceBack(result: MutableList<List<Int>>, combines: ArrayList<Int>, nums: IntArray, index: Int, used: BooleanArray) {
        if (index == nums.size) {
            println("combine=$combines,index=$index")
            result.add(ArrayList(combines))
        } else {
            for ((i, v) in nums.withIndex()) {
                if (used[i]) continue
                if (i > 0 && v == nums[i - 1] && !used[i - 1]) continue
                combines.add(v)
                used[i] = true
                traceBack(result, combines, nums, index + 1, used)
                used[i] = false
                combines.removeAt(combines.size - 1)
            }
        }
    }

}