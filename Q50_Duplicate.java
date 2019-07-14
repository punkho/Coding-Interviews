/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 */
public class Q50_Duplicate {
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        StringBuilder sb = new StringBuilder();
        // 将数组连接成字符串
        for (int i = 0; i < length; i++) {
            sb.append(numbers[i]);
        }
        for (int j = 0; j < length; j++) {
            // 如果该数字第一次出现的下标不等于最后一次出现的下标，则为第一个出现的重复数字，返回true
            if (sb.indexOf(numbers[j] + "") != sb.lastIndexOf(numbers[j] + "")) {
                duplication[0] = numbers[j];
                return true;
            }
        }
        return false;
    }
}
