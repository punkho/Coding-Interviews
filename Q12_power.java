/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */
public class Q12_power {
    public double Power(double base, int n) {
        double res = 1;
        int exponent;
        if (n > 0) {
            exponent = n;
        } else if (n < 0) {
            if (base == 0) {
                System.out.println("Infinity");
            }
            exponent = -n;
        } else {
            // n==0
            return 1;
        }
        while (exponent != 0) {
            if ((exponent & 1) == 1) {
                res *= base;
            }
            // 翻倍
            base *= base;
            // 右移一位
            exponent >>= 1;
        }
        return (n >= 0) ? res : (1 / res);
    }
}
