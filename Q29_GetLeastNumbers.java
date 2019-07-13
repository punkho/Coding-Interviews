import java.util.ArrayList;
import java.util.Arrays;

/**
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
 */
public class Q29_GetLeastNumbers {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> kList = new ArrayList<>();
        if (k > input.length) {
            return kList;
        }
        // 排序
        Arrays.sort(input);
        for (int i = 0; i < k; i++) {
            kList.add(input[i]);
        }
        return kList;
    }
}
