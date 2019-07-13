/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class Q06_minNumberInRotateArray {
    public int minNumberInRotateArray(int[] array) {
        if (array == null) {
            return 0;
        }
        if (array.length == 1) {
            return array[0];
        }
        for (int i = 0; i < array.length - 1; i++) {
            // 遍历数组，若当前元素大于它下一个元素，则下一个元素即为最小元素
            if (array[i] > array[i + 1]) {
                return array[i + 1];
            } else if (i == array.length - 2) {
                // 若倒数第二个元素没有大于最后一个元素，
                // 则该数组为单纯的升序数组，最小元素为第一个元素
                return array[0];
            }
        }
        return 0;
    }
}
