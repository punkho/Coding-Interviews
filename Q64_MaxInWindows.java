import java.util.ArrayList;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}，{2,[3,4,2],6,2,5,1}，{2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}，{2,3,4,2,[6,2,5],1}，{2,3,4,2,6,[2,5,1]}。
 */
public class Q64_MaxInWindows {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        if (num == null || size == 0 || size > num.length) {
            return list;
        }
        int pStart = 0;
        int pEnd = size - 1;
        // 向右滑动窗口
        for (int i = 0; i <= num.length - size; i++) {
            int max = Integer.MIN_VALUE;
            // 遍历窗口中的所有数取出最大值
            for (int j = pStart; j <= pEnd; j++) {
                if (num[j] > max) {
                    max = num[j];
                }
            }
            list.add(max);
            pStart++;
            pEnd++;
        }
        return list;
    }
}
