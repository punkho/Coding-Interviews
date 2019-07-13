/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。
 * 即输出P%1000000007。例如输入{1，2，3，4，5，0}，输出5对。
 */
public class Q35_InversePairs {
    public static int InversePairs(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int[] copy = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }
        int count = InversePairsCore(array, copy, 0, array.length - 1);
        return count;
    }

    private static int InversePairsCore(int[] array, int[] copy, int head, int tail) {
        if (head == tail) {
            return 0;
        }
        // mid的位置
        int mid = (head + tail) >> 1;
        // 递归，分别计算左边和右边内部的逆序对个数
        int leftCount = InversePairsCore(array, copy, head, mid) % 1000000007;
        int rightCount = InversePairsCore(array, copy, mid + 1, tail) % 1000000007;
        // count计数左右两者之间的对数
        int count = 0;
        // i指向mid，j指向tail
        int i = mid;
        int j = tail;
        // 临时数组的指针，指向tail
        int tempCopy = tail;

        while (i >= head && j > mid) {
            // 如果arr[i]大于arr[j]
            if (array[i] > array[j]) {
                // i指向的数大于右半部分所有的数，计数加入j-mid
                count += j - mid;
                // 临时数组存放i指向的数，同时tempCopy和i都向前移动
                copy[tempCopy--] = array[i--];
                if (count >= 1000000007) {
                    count %= 1000000007;
                }
                // 如果arr[i]小于arr[j]，tempCopy和j都向前移动
            } else {
                copy[tempCopy--] = array[j--];
            }
        }
        // 移动完之后将没存放的数字存入临时数组，例如[1,2,3,4][5,6,7,8]，
        // 临时数组存完后面四个[5,6,7,8]，j移动到mid移动终止，将剩下的[1,2,3,4]存入临时数组
        for (; i >= head; i--) {
            copy[tempCopy--] = array[i];
        }
        // 同理，这也是移动完之后将没存放的数字存入临时数组，例如[5,6,7,8][1,2,3,4]，
        // 临时数组存完后面四个[5,6,7,8]，i移动到head移动终止，将剩下的[1,2,3,4]存入临时数组
        for (; j > mid; j--) {
            copy[tempCopy--] = array[j];
        }
        // 将临时数组复制到原数组，以便递归
        System.arraycopy(copy, head, array, head, tail - head + 1);
        return (leftCount + rightCount + count) % 1000000007;
    }
}
