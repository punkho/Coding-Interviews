import java.util.ArrayList;

/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class Q60_PrintII {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        Depth(pRoot, 1, list);
        return list;
    }

    private void Depth(TreeNode root, int depth, ArrayList<ArrayList<Integer>> list) {
        if (root == null) {
            return;
        }
        // 当前深度值大于list的容量，则进行扩容
        if (depth > list.size()) {
            list.add(new ArrayList<Integer>());
        }
        // 将结点值存入list对应层
        list.get(depth - 1).add(root.val);
        // 递归对左子结点、右子结点进行操作
        Depth(root.left, depth + 1, list);
        Depth(root.right, depth + 1, list);
    }
}
