import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 */
public class Q63_GetMedian {
    private int count;
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    // private static final int DEFAULT_INITIAL_CAPACITY = 11;
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(11, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            // PriorityQueue默认是小顶堆，实现大顶堆，需要反转默认排序器
            return o2.compareTo(o1);
        }
    });

    public void Insert(Integer num) {
        count++;
        // 当插入前总数为奇数时，count为偶数
        if (count % 2 == 0) {
            // 如果大顶堆堆顶较大
            if (!maxHeap.isEmpty() && num < maxHeap.peek()) {
                // 将新的数据插入大顶堆并且弹出堆顶
                maxHeap.offer(num);
                num = maxHeap.poll();
            }
            // 将值插入到小顶堆
            minHeap.offer(num);
        } else {
            // 当插入前总数为偶数时，如果小顶堆堆顶较小
            if (!minHeap.isEmpty() && num > minHeap.peek()) {
                // 将新的数据插入小顶堆并且弹出堆顶
                minHeap.offer(num);
                num = minHeap.poll();
            }
            // 将值插入大顶堆
            maxHeap.offer(num);
        }
    }

    public Double GetMedian() {
        double result;
        if (count % 2 == 1) {
            // 总数为奇数时，中位数就是大顶堆堆顶
            result = maxHeap.peek();
        } else {
            // 总数为偶数时，中位数为大顶堆小顶堆堆顶的平均值
            result = (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
        return result;
    }
}
