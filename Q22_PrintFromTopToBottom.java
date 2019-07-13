import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class Q22_PrintFromTopToBottom {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return list;
        }
        // 在队列中加入根节点
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 取出队列头结点
            TreeNode node = queue.poll();
            // 添加到ArrayList
            list.add(node.val);
            // 如果取出的队列头结点有左子节点，则加入到队列尾
            if (node.left != null) {
                queue.offer(node.left);
            }
            // 如果取出的队列头结点有右子节点，则加入到队列尾
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return list;
    }
}
