import java.util.ArrayList;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class Q08_JumpFloor {
    public int JumpFloor(int target) {
//        if (target <= 2) {
//            return target;
//        }
//        return JumpFloor(target - 1) + JumpFloor(target - 2);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= target; i++) {
            if (i <= 2) {
                list.add(i);
            } else {
                list.add(list.get(i - 2) + list.get(i - 3));
            }
        }
        return list.get(list.size() - 1);
    }
}
