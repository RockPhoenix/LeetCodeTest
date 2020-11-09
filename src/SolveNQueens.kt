import java.util.*

/**
 * 51. N 皇后
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 *
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 *  
 *
 * 示例：
 *
 * 输入：4
 * 输出：[
 * [".Q..",  // 解法 1
 *  "...Q",
 *  "Q...",
 *  "..Q."],
 *
 * ["..Q.",  // 解法 2
 *  "Q...",
 *  "...Q",
 *  ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 *  
 *
 * 提示：
 *
 * 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class SolveNQueens {

    fun solveNQueens(n: Int): List<List<String>> {
        val arrays = Array(n) { CharArray(n) }
        for (chars in arrays) Arrays.fill(chars, '.')
        val result: MutableList<List<String>> = ArrayList()
        dfs(result, arrays, 0)
        return result
    }

    private fun dfs(result: MutableList<List<String>>,arrays: Array<CharArray>, row: Int) {
        //递归终止条件
        if (row == arrays.size) {
            result.add(transformList(arrays))
            return
        }
        for (col in arrays.indices) {
            if (isQueenValid(arrays, row, col)) {
                arrays[row][col] = 'Q'
                dfs(result, arrays, row + 1)
                arrays[row][col] = '.'
            }
        }
    }
    /**
     * 因为遍历是从上及下,所以判断对角线及横竖方向是否有Queen只需要判断元素上方既可
     */
    private fun isQueenValid(arrays: Array<CharArray>, row: Int, column: Int): Boolean {
        //判断
        for (i in 0 until row) {
            if (arrays[i][column] == 'Q') {
                return false
            }
        }

        //判断左上
        var rowIndex = row - 1
        var columnIndex = column - 1
        while (rowIndex >= 0 && columnIndex >= 0) {
            if (arrays[rowIndex][columnIndex] == 'Q') return false
            rowIndex--
            columnIndex--
        }
        //判断右上
        rowIndex = row - 1
        columnIndex += 1
        while (rowIndex >= 0 && columnIndex < arrays.size) {
            if (arrays[rowIndex][columnIndex] == 'Q') return false
            rowIndex--
            columnIndex++
        }
        return true
    }

    private fun transformList(arrays: Array<CharArray>): List<String> {
        val list: MutableList<String> = ArrayList()
        for (i in arrays.indices) {
            list.add(arrays[i].toString())
        }
        return list
    }

}