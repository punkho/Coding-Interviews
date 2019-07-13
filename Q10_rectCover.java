import java.util.ArrayList;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class Q10_rectCover {
    public int RectCover(int target) {
//        if (target <= 2) {
//            return target;
//        }
//        return RectCover(target - 1) + RectCover(target - 2);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i <= target; i++) {
            if (i <= 2) {
                list.add(i);
            } else {
                list.add(list.get(i - 1) + list.get(i - 2));
            }
        }
        return list.get(list.size() - 1);
    }
}
