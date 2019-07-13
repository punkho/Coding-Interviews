/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class Q15_reverseList {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode newHead = null, pNode = head, pPre = null;
        while (pNode != null) {
            ListNode pNext = pNode.next;
            if (pNext == null) {
                newHead = pNode;
            }
            // 替换结点的下一个结点为前结点
            pNode.next = pPre;
            // 向后遍历
            pPre = pNode;
            pNode = pNext;
        }
        return newHead;
    }
}
