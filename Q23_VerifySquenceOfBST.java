/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes，否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class Q23_VerifySquenceOfBST {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0) {
            return false;
        }
        return verifySquenceOfBSTCore(sequence, 0, sequence.length - 1);
    }

    private boolean verifySquenceOfBSTCore(int[] sequence, int start, int end) {
        if (end <= start) {
            return true;
        }
        int i = start;
        // 在数组中找到第一个比根节点值大的元素，为左右子树分界元素
        for (; i < end; i++) {
            if (sequence[i] > sequence[end]) {
                break;
            }
        }
        // 遍历右子树，如果发现小于根节点值的元素则返回false
        for (int j = i; j < end; j++) {
            if (sequence[j] < sequence[end]) {
                return false;
            }
        }
        // 在左右子树中递归上述操作
        return verifySquenceOfBSTCore(sequence, start, i - 1) && verifySquenceOfBSTCore(sequence, i, end - 1);
    }
}
