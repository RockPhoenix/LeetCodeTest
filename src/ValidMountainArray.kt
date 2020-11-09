/**
 * 941. 有效的山脉数组
 */
class ValidMountainArray {
    fun validMountainArray(A: IntArray): Boolean {
        val len = A.size
        if (len < 3) return false
        var start = 0
        var tail = len - 1
//        while ((start != tail)) {
//            if (start > tail) return false
//            if (A[start] >= A[start + 1] && A[tail] >= A[tail - 1]) return false
//            if (A[start] < A[start + 1]) {
//                start++
//            }
//            if (A[tail] < A[tail - 1]) {
//                tail--
//            }
//        }
//        if (start == 0 || tail == A.size - 1) return false
//        return true
        while (start < len - 1 && A[start] < A[start + 1]) {
            start++
        }
        while (tail > 0 && A[tail] < A[tail - 1]) {
            tail--
        }
        return start == tail && start != 0 && tail != len - 1
    }
}