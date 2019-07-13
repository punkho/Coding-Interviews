import java.util.ArrayList;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class Q13_ReOrderArray {
    public void reOrderArray(int[] array) {
        ArrayList<Integer> odd = new ArrayList<>();
        ArrayList<Integer> even = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                // 将奇数按顺序加入odd
                odd.add(array[i]);
            } else {
                // 将偶数按顺序加入even
                even.add(array[i]);
            }
        }
        // 合并两个ArrayList
        odd.addAll(even);
        for (int i = 0; i < array.length; i++) {
            // 将ArrayList的值赋给原数组
            array[i] = odd.get(i);
        }
    }
}
