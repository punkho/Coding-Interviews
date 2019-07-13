/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class Q14_FindKthToTail {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k == 0) {
            return null;
        }
        ListNode p = head, pK = head;
        // 第一个指针先走k步
        for (int i = 0; i < k; i++) {
            if (p != null) {
                p = p.next;
            } else {
                return null;
            }
        }
        // 两个指针同时向后遍历，直至第一个指针到达null，第二个指针指向倒数第k个结点
        while (p != null) {
            p = p.next;
            pK = pK.next;
        }
        return pK;
    }
}
