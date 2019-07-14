/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 */
public class Q61_SerializeAndDeserialize {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    String Serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        serializeCore(root, sb);
        return sb.toString();
    }

    void serializeCore(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#,");
            return;
        }
        // 前序遍历序列化二叉树
        sb.append(root.val);
        sb.append(',');
        serializeCore(root.left, sb);
        serializeCore(root.right, sb);
    }

    int index = -1;

    TreeNode Deserialize(String str) {
        if (str.length() == 0) {
            return null;
        }
        // 按照逗号分割
        String[] strs = str.split(",");
        return deserializeCore(strs);
    }

    TreeNode deserializeCore(String[] strs) {
        index++;
        // 按照前序遍历顺序反序列化二叉树
        if (!strs[index].equals("#")) {
            TreeNode root = new TreeNode(0);
            root.val = Integer.parseInt(strs[index]);
            root.left = deserializeCore(strs);
            root.right = deserializeCore(strs);
            return root;
        }
        return null;
    }
}
