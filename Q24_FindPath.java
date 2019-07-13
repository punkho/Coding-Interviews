import java.util.ArrayList;

/**
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class Q24_FindPath {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();
    private ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return listAll;
        }
        // 目标路径长度减去根节点的值
        target -= root.val;
        if (target >= 0) {
            // 将root值加入临时路径list
            list.add(root.val);
            // 判断路径是否满足：当前目标路径长度为0；左子树为空；右子树为空。
            if (target == 0 && root.left == null && root.right == null) {
                // 满足条件则将该条临时路径加入路径集
                // 此处add添加的是引用，如果不new，后面的操作会更改这个已经存储完的路径
                listAll.add(new ArrayList<>(list));
            }
            // 不满足条件，递归遍历左子树
            FindPath(root.left, target);
            // 仍旧不满足，递归遍历右子树
            FindPath(root.right, target);
            // 在该节点下寻找完毕，返回他的父节点
            list.remove(list.size() - 1);
        }
        return listAll;
    }
}
