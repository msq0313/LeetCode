package Basic;

import java.util.ArrayDeque;
import java.util.Queue;

public class TwoQueueImplStack {
    private Queue<Integer> queue1 = new ArrayDeque<>();
    private Queue<Integer> queue2 = new ArrayDeque<>();

    /**
     * 入栈
     * @param element 压入的数据
     */
    public void push(Integer element) {
        //两队列为空，优先考虑队列1
        if (queue1.isEmpty() && queue2.isEmpty()) {
            queue1.add(element);
        }
        //队列一为空，队列二有数据，压入队列二
        if (queue1.isEmpty()) {
            queue2.add(element);
        }
        //队列二为空，队列一有数据，压入队列一
        if (queue2.isEmpty()) {
            queue1.add(element);
        }
    }

    /**
     * 出栈
     * @return Integer element
     */
    public Integer pop() {
        //两个队列为空时，直接抛出异常
        if (queue1.isEmpty() && queue2.isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        //如果queue1为空，将queue2中的元素依次加入到queue1，剩最后一个元素，弹出最后一个元素
        if (queue1.isEmpty()) {
            while (queue2.size() > 1) {
                queue1.add(queue2.poll());
            }
            return queue2.poll();
        }

        //如果queue2为空，将queue1中的元素依次加入到queue2，剩最后一个元素，弹出最后一个元素
        if (queue2.isEmpty()) {
            while (queue1.size() > 1) {
                queue2.add(queue1.poll());
            }
            return queue1.poll();
        }
        return null;
    }

    public static void main(String[] args) {
        TwoQueueImplStack qs = new TwoQueueImplStack();
        System.out.println(qs.pop());
        qs.push(2);
        qs.push(4);
        qs.push(7);
        qs.push(5);
        System.out.println(qs.pop());
        System.out.println(qs.pop());

        qs.push(1);
        System.out.println(qs.pop());
    }

}
