import java.util.ArrayList;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
public class Q42_FindNumbersWithSum {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        if (array.length < 2 || (array[array.length - 1] + array[array.length - 2] < sum)) {
            return list;
        }
        int pLow = 0;
        int pHigh = array.length - 1;
        while (pLow < pHigh) {
            int current = array[pLow] + array[pHigh];
            if (current == sum) {
                // 当前和=目标和，将两个数添加至序列，停止移动
                list.add(array[pLow]);
                list.add(array[pHigh]);
                break;
            } else if (current < sum) {
                // 当前和<目标和，pLow向后移动
                pLow++;
            } else {
                // 当前和>目标和，pHigh向前移动
                pHigh--;
            }
        }
        return list;
    }
}
