/**
 * 求出1~13的整数中1出现的次数，并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次，
 * 但是对于后面问题他就没辙了。ACMer希望你们帮帮他，并把问题更加普遍化，
 * 可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 */
public class Q31_NumberOf1Between1AndN {
    public int NumberOf1Between1AndN(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            // 将数字转换成char数组，如13转成‘1’‘3’
            char[] cs = String.valueOf(i).toCharArray();
            // 计数
            for (int j = 0; j < cs.length; j++) {
                if (cs[j] == '1') {
                    count++;
                }
            }
        }
        return count;
    }
}
