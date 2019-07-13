import java.util.ArrayList;
import java.util.Collections;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a、b、c所能排列出来的所有字符串abc，acb，bac，bca，cab和cba。
 */
public class Q27_Permutation {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if (str != null && str.length() > 0) {
            permutationCore(str.toCharArray(), 0, list);
            Collections.sort(list);
        }
        return list;
    }

    private void permutationCore(char[] cs, int i, ArrayList<String> list) {
        if (i == cs.length - 1) {
            String val = String.valueOf(cs);
            if (!list.contains(val)) {
                list.add(val);
            }
        } else {
            for (int j = i; j < cs.length; j++) {
                // 字符换位
                swap(cs, i, j);
                // 递归选择换位字符
                permutationCore(cs, i + 1, list);
                // 将字符再换回到上一个状态
                swap(cs, i, j);
            }
        }
    }

    private void swap(char[] cs, int i, int j) {
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }
}
