import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */
public class Q20_minStack {
    private Stack<Integer> stack = new Stack<>();
    // 定义一个辅助栈用来存储最小元素
    private Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        // stack入栈
        stack.push(node);
        // 如果minStack为空，则将该元素入栈
        if (minStack.isEmpty()) {
            minStack.push(node);
        }
        // 如果minStack非空，比较minStack栈顶与入栈stack元素的大小，
        // 如果minStack栈顶小，则再入一遍栈顶元素；如果入栈元素小，则将该元素入栈minStack
        minStack.push((minStack.peek() > node) ? node : minStack.peek());
    }

    public void pop() {
        // stack和minStack均出栈
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        // 返回minStack的栈顶
        return minStack.peek();
    }
}
