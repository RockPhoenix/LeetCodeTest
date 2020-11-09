/**
 * 57. 插入区间
 */
class Insert {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        if (newInterval.isEmpty()) return intervals
        var startIndex = -1
        var endIndex = -1
        val insertArray = intArrayOf(2)
        insertArray[0] = newInterval[0]
        insertArray[1] = newInterval[1]
        val start = newInterval[0]
        val end = newInterval[1]
        for ((i, intArray) in intervals.withIndex()) {
            if (start >= intArray[0] && start <= intArray[1]) {
                insertArray[0] = intArray[0]
                startIndex = i
            }
        }
        if (startIndex == -1)
            for ((i, intArray) in intervals.withIndex()) {
                if (end >= intArray[0] && end <= intArray[1]) {
                    insertArray[1] = intArray[1]
                    endIndex = i
                }
            }

    }
}