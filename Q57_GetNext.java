/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class Q57_GetNext {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        // 如果结点有右子树，那么它的下一个结点就是它的右子树的最左子结点
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }
        // 结点没有右子树
        while (pNode.next != null) {
            // 如果结点是它父结点的左子结点，那么它的下一个结点就是它的父结点
            if (pNode.next.left == pNode) {
                return pNode.next;
            }
            // 如果结点是它父结点的右子结点，则一直向上遍历，直到找到一个是它父结点的左子结点的结点
            pNode = pNode.next;
        }
        return null;
    }
}
