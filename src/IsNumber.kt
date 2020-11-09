/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，
 * 但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class IsNumber {

    fun isNumber(s: String): Boolean {
        //字符串是否表示数值
        var hasNum = false
        //字符串是否包含e或E的标识
        var hasE = false
        //字符串是否包含小数点的标识
        var hasDecimalPoint = false
        //字符串为空或长度为0返回false
        if (s.isEmpty()) return false
        //字符串
        val length = s.trim().length
        //将string去空格后转化为char数组
        val chars = s.trim().toCharArray()
        //遍历数组
        for ((index, char) in chars.withIndex()) {
            //判断是否包含整数
            if (char in '0'..'9') {
                hasNum = true
            } else if (char == 'e' || char == 'E') {
                //e或E不能是第一位,只能出现一次,前面必须有数字,后面必须跟整数
                if (!hasNum || index == 0 || index == length - 1 || hasE) return false
                hasE = true
                //重新将hasNum标识置为false
                hasNum = false
            } else if (char == '.') {
                //小数点不能重复只能有一个,前后可以不跟数字但是不能有e/E
                if (hasDecimalPoint || hasE) return false
                hasDecimalPoint = true
            } else if (char == '+' || char == '-') {
                //正负号只能出现在第一位或者e/E的后面
                if (index != 0 && chars[index - 1] != 'e' && chars[index - 1] != 'E') return false
            } else {
                return false
            }
        }
        return hasNum
    }

}