/**
 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，
 * 要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0。
 */
public class Q49_StrToInt {
    public int StrToInt(String str) {
        if (str.length() == 0) {
            return 0;
        }
        char[] numbers = str.toCharArray();
        // 定义负号标志
        int minus = 0;
        // 如果第一位是负号，则标志置1
        if (numbers[0] == '-') {
            minus = 1;
        }
        int sum = 0;
        for (int i = minus; i < numbers.length; i++) {
            if (numbers[i] == '+') {
                continue;
            }
            // 判断每个字符是否在0~9之间
            if (numbers[i] < 48 || numbers[i] > 57) {
                return 0;
            }
            // 转成int
            sum = sum * 10 + (numbers[i] - 48);
        }
        // 最后添加正负属性
        return minus == 0 ? sum : sum * -1;
    }
}
