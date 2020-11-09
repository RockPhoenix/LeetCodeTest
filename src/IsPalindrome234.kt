/**
 * 234. 回文链表
 * 请判断一个链表是否为回文链表
 */
class IsPalindrome234 {

    fun isPalindrome(head: ListNode?): Boolean {
        if (head?.next == null) return true
        var nodeArray = intArrayOf()
        var node = head
        while (node != null) {
            nodeArray += node.`val`
            node = node.next
        }
        var front = 0
        var tail = nodeArray.size - 1
        while (front <= tail) {
            if (nodeArray[front] != nodeArray[tail]) return false
            front++
            tail--
        }
        return true
    }

}