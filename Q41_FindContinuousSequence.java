import java.util.ArrayList;

/**
 * 小明很喜欢数学，有一天他在做数学作业时，要求计算出9~16的和，他马上就写出了正确答案是100。
 * 但是他并不满足于此，他在想究竟有多少种连续的正数序列的和为100（至少包括两个数）。
 * 没多久，他就得到另一组连续正数和为100的序列：18，19，20，21，22。
 * 现在把问题交给你，你能不能也很快的找出所有和为S的连续正数序列？ Good Luck！
 */
public class Q41_FindContinuousSequence {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();
        int pLow = 1, pHigh = 2;
        while (pLow < pHigh) {
            int currentSum = (pLow + pHigh) * (pHigh - pLow + 1) / 2;
            // 当前两个指针范围内的数字和等于目标和，添加至list
            if (currentSum == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = pLow; i <= pHigh; i++) {
                    list.add(i);
                }
                listAll.add(list);
                pLow++;
            } else if (currentSum < sum) {
                // 当前两个指针范围内的数字和小于目标和，右边指针向后移动，增大范围
                pHigh++;
            } else {
                // 当前两个指针范围内的数字和大于目标和，左边指针向后移动，减小范围
                pLow++;
            }
        }
        return listAll;
    }
}
