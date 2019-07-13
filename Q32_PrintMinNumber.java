import java.util.ArrayList;
import java.util.Comparator;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class Q32_PrintMinNumber {
    public String PrintMinNumber(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);
        }
        list.sort(new Comparator<Integer>() {
            // 重写比较规则
            @Override
            public int compare(Integer str1, Integer str2) {
                String s1 = str1 + "" + str2;
                String s2 = str2 + "" + str1;
                // 如果ab小于ba，则表示a小于b，将a排在b前面
                return s1.compareTo(s2);
            }
        });
        // 连接排完序的所有数字
        for (int i : list) {
            sb.append(i);
        }
        return sb.toString();
    }
}
