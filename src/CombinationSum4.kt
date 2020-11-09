class CombinationSum4 {

    fun combinationSum4(nums: IntArray, target: Int): Int {
        val result: ArrayList<ArrayList<Int>> = ArrayList()
        dfs(result, arrayListOf(), nums, target)
        return result.size
    }

    private fun dfs(result: ArrayList<ArrayList<Int>>, combine: ArrayList<Int>, nums: IntArray, target: Int) {
        if (target < 0) return
        if (target == 0) {
            result.add(ArrayList(combine))
        } else {
            for (v in nums) {
                combine.add(v)
                dfs(result, combine, nums, target - v)
                combine.removeAt(combine.size - 1)
            }
        }
    }

}