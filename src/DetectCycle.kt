/**
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * 注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
 * 说明：不允许修改给定的链表。
 */
class DetectCycle {

    fun detectCycle(head: ListNode?): ListNode? {
        //假设链表长度为a + b,a = 头节点到链表环入口的长度,b = 链表环长度
        //赋值快慢指针为头指针
        var fast: ListNode? = head
        var slow: ListNode? = head
        if (head?.next == null) return null
        while (true) {
            //如果快指针到达链表尾,说明链表无环,否则有环,快慢指针一定能相遇
            if (fast?.next == null) return null
            //快指针一次前进两个节点,慢指针一个
            fast = fast.next!!.next
            slow = slow?.next
            //第一次相遇时,快指针步数为f,慢指针步数为s,f = 2s,快指针比慢指针多走了n个环(n未知)也就是nb
            //得f = s + nb,两式相减得f = 2nb,则s = nb
            if (fast == slow) break
        }
        //现在slow指针走了nb步,要将它继续前进到链表环节点处
        //第一次相遇后重新将快指针定位至头节点,这次前进步数为1
        fast = head
        while (fast != slow){
            slow = slow?.next
            fast = fast?.next
        }
        return slow
    }

}