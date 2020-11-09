import java.lang.StringBuilder

/**
 * 140. 单词拆分 II
 */
class WordBreak {

    fun wordBreak(s: String, wordDict: List<String>): List<String> {
        val result = arrayListOf<String>()
        var start = 0
        val sentence = StringBuilder()
        for (i in s.indices) {
            val splitString = s.substring(start, i)
            //判断分割的字符串是否在字典中,如果有则添加到句子中
            if (wordDict.contains(splitString)) {
                sentence.append(splitString)
                if (i != s.length) sentence.append(" ")
                start = i
            }
        }
    }

}