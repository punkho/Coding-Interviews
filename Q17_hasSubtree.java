/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。
 * （ps：我们约定空树不是任意一个树的子结构）
 */
public class Q17_HasSubtree {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;
        if (root1 != null && root2 != null) {
            if (root1.val == root2.val) {
                // 先找根节点是否满足
                result = hasSubtreeCore(root1, root2);
            }
            if (!result) {
                // 如果根节点不满足，则找左子树
                result = hasSubtreeCore(root1.left, root2);
            }
            if (!result) {
                // 如果左子树依旧不满足，则找右子树
                result = hasSubtreeCore(root1.right, root2);
            }
        }
        return result;
    }

    private boolean hasSubtreeCore(TreeNode node1, TreeNode node2) {
        if (node2 == null) {
            // node2递归完则表示树B全部结点相同，返回true
            return true;
        }
        if (node1 == null) {
            return false;
        }
        if (node1.val != node2.val) {
            return false;
        }
        // 在根结点相同的情况下，比较该根节点下的左右子树是否相同
        return hasSubtreeCore(node1.left, node2.left) && hasSubtreeCore(node1.right, node2.right);
    }
}
