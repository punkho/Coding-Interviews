/**
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
public class Q55_EntryNodeOfLoop {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        // 两个指针均指向头结点
        ListNode p1, p2;
        p1 = p2 = pHead;
        while (p2 != null && p2.next != null) {
            // p1每次往后移动一步
            p1 = p1.next;
            // p2每次往后移动两步
            p2 = p2.next.next;
            // 两者如果相遇，则一定相遇在环中
            if (p1 == p2) {
                // 将p2重新指向头结点
                p2 = pHead;
                while (p1 != p2) {
                    // 两个指针均一步一步往后移动
                    p1 = p1.next;
                    p2 = p2.next;
                }
                // 两个指针相遇时即为环的入口结点
                return p1;
            }
        }
        return null;
    }
}
