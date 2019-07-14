/**
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class Q58_IsSymmetrical {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return comRoot(pRoot.left, pRoot.right);
    }

    private boolean comRoot(TreeNode pLeft, TreeNode pRight) {
        // 如果左子树为空，判断右子树是否为空
        if (pLeft == null) {
            return pRight == null;
        }
        // 如果左子树不为空，右子树为空,则不对称
        if (pRight == null) {
            return false;
        }
        // 左右子结点值不同，则不对称
        if (pLeft.val != pRight.val) {
            return false;
        }
        // 比较左子树的右结点和右子树的左结点
        // 比较左子树的左结点和右子树的右结点
        return comRoot(pLeft.right, pRight.left) && comRoot(pLeft.left, pRight.right);
    }
}
