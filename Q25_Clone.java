/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
 * 另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class Q25_Clone {
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        // 当前指针指向原链表头
        RandomListNode currentNode = pHead;
        // 在每个结点后链接一个它的复制结点
        while (currentNode != null) {
            // 创建复制结点
            RandomListNode cloneNode = new RandomListNode(currentNode.label);
            // 定义当前结点的后一个结点
            RandomListNode nextNode = currentNode.next;
            // 将复制结点链接到当前结点的后面
            currentNode.next = cloneNode;
            // 将原先的后一个结点链接到复制节点后面
            cloneNode.next = nextNode;
            // 将指针移动到下一个结点
            currentNode = nextNode;
        }
        // 将当前指针重新指向原链表头
        currentNode = pHead;
        while (currentNode != null) {
            // 判断当前结点是否存在随机指针，如果存在，则将当前结点的下一个结点（即复制结点）的随机指针
            // 指向当前结点的随机结点的后一个结点（即随机指针的复制结点）
            currentNode.next.random = currentNode.random == null ? null : currentNode.random.next;
            // 将指针移动到下下个结点（因为下一个是复制结点）
            currentNode = currentNode.next.next;
        }
        // 将当前指针重新指向原链表头
        currentNode = pHead;
        // 定义复制链表的表头为原链表头的下一个结点
        RandomListNode pCloneHead = pHead.next;
        while (currentNode != null) {
            // 定义复制链表的指针指向的结点为当前指针指向结点的后一个
            RandomListNode cloneNode = currentNode.next;
            // 将当前复制结点的后一个结点（即原本链表的后一个结点）重新链接回当前结点
            currentNode.next = cloneNode.next;
            // 链接复制结点的下下个结点
            cloneNode.next = cloneNode.next == null ? null : cloneNode.next.next;
            // 将指针移动到后一个结点（因为复制结点已从链表中断出）
            currentNode = currentNode.next;
        }
        return pCloneHead;
    }
}
