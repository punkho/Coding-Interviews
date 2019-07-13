/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class Q39_IsBalanced {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean IsBalanced_Solution(TreeNode root) {
        return getDepth(root) != -1;
    }

    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 左子树的深度
        int left = getDepth(root.left);
        // 如果左子树不平衡直接返回-1，表明该树不平衡
        if (left == -1) {
            return -1;
        }
        // 右子树的深度
        int right = getDepth(root.right);
        // 如果右子树不平衡直接返回-1，表明该树不平衡
        if (right == -1) {
            return -1;
        }
        // 如果左右子树深度差超过1，则返回-1，表明该树不平衡；
        // 如果深度差小于等于1，则返回当前结点的深度
        return Math.abs(left - right) > 1 ? -1 : (1 + Math.max(left, right));
    }
}
