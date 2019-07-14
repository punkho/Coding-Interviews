/**
 * 给你一根长度为n的绳子，请把绳子剪成m段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为k[0]，k[1]，…k[m]。请问k[0]×k[1]×…×k[m]可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度为2、3、3的三段，此时得到的最大的乘积是18。
 */
public class Q67_MaxProductAfterCutting {
    public int maxProductAfterCutting(int length) {
        if (length < 2) {
            return 0;
        } else if (length <= 3) {
            return length - 1;
        }
        int countThree = length / 3 - 1;
        // 少剪一次3时余下的长度
        int remain = length - countThree * 3;
        // 余下3乘3，余下4乘4，余下5乘6
        return (remain == 5) ? (int) Math.pow(3, countThree) * 6 : (int) Math.pow(3, countThree) * remain;
    }
}
