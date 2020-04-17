package Basic;

import java.util.Stack;

public class TwoStackImplQueue {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    /**
     * 入队
     * @param element 入队的元素
     */
    private void push(Integer element) {
        stack1.push(element);
    }

    /**
     * 出队
     * @return Integer
     */
    private Integer poll() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            throw new RuntimeException("queue is empty");
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        TwoStackImplQueue sq = new TwoStackImplQueue();
        sq.push(1);
        sq.push(3);
        sq.push(5);
        sq.push(4);
        sq.push(2);

        System.out.println(sq.poll());
        System.out.println(sq.poll());

        sq.push(7);
        System.out.println(sq.poll());
        System.out.println(sq.poll());
        System.out.println(sq.poll());
        System.out.println(sq.poll());
    }
}
