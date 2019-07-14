/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5。
 */
public class Q56_DeleteDuplication {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        // 如果此时结点值等于后一个结点值
        if (pHead.val == pHead.next.val) {
            ListNode pNode = pHead.next;
            while (pNode != null && pNode.val == pHead.val) {
                // 直至移动到第一个值不同的结点
                pNode = pNode.next;
            }
            // 继续遍历
            return deleteDuplication(pNode);
        } else {
            // 值不相等则链接
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }
    }
}
