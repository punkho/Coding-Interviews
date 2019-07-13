/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class Q18_Mirror {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public void Mirror(TreeNode root) {
        TreeNode temp = null;
        if (root != null) {
            // 交换根节点下左右子节点
            temp = root.left;
            root.left = root.right;
            root.right = temp;
            if (root.left != null) {
                // 递归，当根节点左子树不为空，交换左右子节点
                Mirror(root.left);
            }
            if (root.right != null) {
                // 递归，当根节点右子树不为空，交换左右子节点
                Mirror(root.right);
            }
        }
    }
}
