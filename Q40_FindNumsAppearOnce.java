/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。
 */
public class Q40_FindNumsAppearOnce {
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        if (array.length < 2) {
            return;
        }
        int myXor = 0;
        int flag = 1;
        // 将数组全体元素进行异或，结果即为两个只出现一次的元素的异或结果
        for (int i = 0; i < array.length; i++) {
            myXor ^= array[i];
        }
        // 定义一个flag=1用于找到异或结果中第一个为1的位的位置，
        // 方法:将flag与结果数字进行&运算（与运算），若结果为0，则flag使用左移运算，直至找到第一个1的位
        while ((myXor & flag) == 0) {
            flag <<= 1;
        }
        for (int i = 0; i < array.length; i++) {
            // 依照该位是否为1，将原数组分为两个子数组，再分别进行全体异或，结果即为两个只出现一次的数
            if ((flag & array[i]) == 0) {
                num2[0] ^= array[i];
            } else {
                num1[0] ^= array[i];
            }
        }
    }
}
