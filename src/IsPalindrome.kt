/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 *
 */
class IsPalindrome {

    fun isPalindrome(s: String): Boolean {
        s.toLowerCase()
        val charArray = s.toCharArray()
        var newCharArray = emptyArray<Char>()
        for (char in charArray) {
            if (char.isLetterOrDigit()) newCharArray = newCharArray.plus(char)
        }
        if (newCharArray.size % 2 != 0) return false
        var front = 0
        var tail = newCharArray.size - 1
        while (front < tail) {
            if (newCharArray[front] != newCharArray[tail])return false
            front++
            tail--
        }
        return true
    }

}