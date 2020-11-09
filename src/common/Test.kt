package common

import PermuteUnique
import Solution

class Test {

    companion object{
        @JvmStatic
        fun main(args:Array<String>) {
            val solution1 = Solution()
            var solution2 = Solution()
            solution2 = solution1
            println(solution1 == solution2)
        }
    }

}
