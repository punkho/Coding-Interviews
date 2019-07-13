import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */
public class Q03_PrintListFromTailToHead {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    // 利用一个栈，栈的特点是先进后出。在输入链表时每经过一个结点，将该结点放入一个栈中。
    // 当遍历完整个链表后，再从栈顶开始逐个输出结点的值，实现链表的反转。
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        while (listNode != null) {
            // 依次将结点压入栈中
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.isEmpty()) {
            // 依次出栈
            list.add(stack.pop());
        }
        return list;
    }
}
