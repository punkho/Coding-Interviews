/**
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class Q36_FindFirstCommonNode {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != p2) {
            // 当遍历完链表1则接上链表2
            p1 = (p1 == null ? pHead2 : p1.next);
            // 当遍历完链表2则接上链表1
            p2 = (p2 == null ? pHead1 : p2.next);
        }
        return p1;
    }
}
