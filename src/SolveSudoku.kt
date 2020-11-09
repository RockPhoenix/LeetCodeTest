/**
 * 编写一个程序，通过已填充的空格来解决数独问题。
 * 一个数独的解法需遵循如下规则：
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 空白格用 '.' 表示。
 * Note:
 * 给定的数独序列只包含数字 1-9 和字符 '.' 。
 * 你可以假设给定的数独只有唯一解。
 * 给定数独永远是 9x9 形式的。
 *
 */
class SolveSudoku {

    fun solveSudoku(board: Array<CharArray>) {
        backTracker(board, 0, 0)
    }

    private fun backTracker(board: Array<CharArray>, row: Int, col: Int): Boolean {
        //递归终止条件
        if (row == 9) return true
        if (col == 9) return backTracker(board, row + 1, 0)
        //已有数字则跳过判断下一位
        if (board[row][col] != '.') return backTracker(board, row, col + 1)
        for (index in 1..9) {
            val char = '0' + index
            if (!isValid(board, row, col, char)) continue
            board[row][col] = char
            if (backTracker(board, row, col)) return true
            board[row][col] = '.'
        }
        return false
    }

    private fun isValid(board: Array<CharArray>, row: Int, col: Int, value: Char): Boolean {
        //横行不能有相同数字
        for (i in 0..8) if (board[row][i] == value) return false
        //竖列不能有相同数字
        for (i in 0..8) if (board[i][col] == value) return false
        //3*3不能有相同数字
        for (i in 0..2) {
            val k = (row / 3) * 3 + (row + i) % 3
            for (j in 0..2) {
                val l = (col / 3) * 3 + (col + j) % 3
                if (board[k][l] == value) {
                    return false
                }
            }
        }
        return true
    }
}