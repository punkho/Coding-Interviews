import java.util.ArrayList;
import java.util.Stack;

/**
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class Q59_Print {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        int layer = 1;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        // 先将根节点（第一层）入栈s1
        s1.push(pRoot);
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        while (!s1.isEmpty() || !s2.isEmpty()) {
            // 奇数层
            if (layer % 2 != 0) {
                ArrayList<Integer> temp = new ArrayList<>();
                while (!s1.isEmpty()) {
                    // 出栈所有结点
                    TreeNode node = s1.pop();
                    if (node != null) {
                        temp.add(node.val);
                        // 将所有结点的左右子节点从左至右入栈s2
                        s2.push(node.left);
                        s2.push(node.right);
                    }
                }
                if (!temp.isEmpty()) {
                    list.add(temp);
                    layer++;
                }
            } else {
                // 偶数层
                ArrayList<Integer> temp = new ArrayList<>();
                while (!s2.isEmpty()) {
                    // 出栈所有结点
                    TreeNode node = s2.pop();
                    if (node != null) {
                        temp.add(node.val);
                        // 将所有结点的左右子节点从右至左入栈s2
                        s1.push(node.right);
                        s1.push(node.left);
                    }
                }
                if (!temp.isEmpty()) {
                    list.add(temp);
                    layer++;
                }
            }
        }
        return list;
    }
}
