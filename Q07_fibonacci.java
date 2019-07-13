import java.util.ArrayList;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 */
public class Q07_fibonacci {
    public int Fibonacci(int n) {
//        if (n <= 1) {
//            return n;
//        }
//        return Fibonacci(n - 1) + Fibonacci(n - 2);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            if (i <= 1) {
                list.add(i);
            } else {
                list.add(list.get(i - 1) + list.get(i - 2));
            }
        }
        return list.get(list.size() - 1);
    }
}
