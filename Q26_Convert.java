/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class Q26_Convert {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private TreeNode preNode = null;
    private TreeNode head = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        convertCore(pRootOfTree);
        return head;
    }

    private void convertCore(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return;
        }
        // 递归遍历左子树
        convertCore(pRootOfTree.left);
        if (preNode == null) {
            preNode = pRootOfTree;
            head = pRootOfTree;
        } else {
            // 将当前结点链接到前一个结点的右边
            preNode.right = pRootOfTree;
            // 将前一个结点链接到当前结点的左边
            pRootOfTree.left = preNode;
            // 将前一个结点指向当前结点
            preNode = pRootOfTree;
        }
        // 递归遍历右子树
        convertCore(pRootOfTree.right);
    }
}
