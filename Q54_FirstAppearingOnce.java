/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 */
public class Q54_FirstAppearingOnce {
    // 一个字符占8bit，ASCII码表中的字符256个，但只有128可见，创建128大小的数组
    private int[] hashTable = new int[128];
    private StringBuilder sb = new StringBuilder();

    public void Insert(char ch) {
        // 将每个输入的字符append到StringBuilder上
        sb.append(ch);
        hashTable[ch]++;
    }

    public char FirstAppearingOnce() {
        // 将StringBuilder转换成char数组
        char[] str = sb.toString().toCharArray();
        for (char c : str) {
            // 当遍历到第一个计数为1的字符，返回该字符
            if (hashTable[c] == 1) {
                return c;
            }
        }
        return '#';
    }
}
