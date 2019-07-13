/**
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class Q33_GetUglyNumber {
    public int GetUglyNumber_Solution(int index) {
        if (index <= 0) {
            return 0;
        }
        int[] result = new int[index];
        // 定义三个指针
        int count, i2, i3, i5, temp;
        count = i2 = i3 = i5 = 0;
        result[0] = 1;
        while (count < index - 1) {
            // 比较当前丑数分别乘以2、3和5之后值的大小,只存入最小值并移动对应指针
            temp = Math.min(result[i2] * 2, Math.min(result[i3] * 3, result[i5] * 5));
            if (temp == result[i2] * 2) {
                i2++;
            }
            if (temp == result[i3] * 3) {
                i3++;
            }
            if (temp == result[i5] * 5) {
                i5++;
            }
            result[++count] = temp;
        }
        return result[index - 1];
    }
}
