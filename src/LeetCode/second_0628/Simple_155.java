package LeetCode.second_0628;

import java.util.Stack;
/*
155. 最小栈
设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。

push(x) —— 将元素 x 推入栈中。
pop() —— 删除栈顶的元素。
top() —— 获取栈顶元素。
getMin() —— 检索栈中的最小元素。

示例:

输入：
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

输出：
[null,null,null,null,-3,null,0,-2]

解释：
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.getMin();   --> 返回 -2.

提示：

pop、top 和 getMin 操作总是在 非空栈 上调用。
 */
public class Simple_155 {
    static class MinStack {
        // 数据栈
        private final Stack<Integer> datastack;
        // 辅助栈
        private final Stack<Integer> minstack;
        /** initialize your data structure here. */
        public MinStack() {
            datastack = new Stack<>();
            minstack = new Stack<>();
        }

        public void push(int x) {
            datastack.push(x);
            if (minstack.isEmpty() || x < minstack.peek()) {
                minstack.push(x);
            } else if (x >= minstack.peek()) {
                minstack.push(minstack.peek());
            }
        }

        public void pop() {
            if (datastack.isEmpty()) {
                return;
            }
            datastack.pop();
            minstack.pop();
        }

        public int top() {
            if (datastack.isEmpty())
                throw new RuntimeException("栈空");
            return datastack.peek();
        }

        public int getMin() {
            if (minstack.isEmpty())
                throw new RuntimeException("栈空");
            return minstack.peek();
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();

//        minStack.push(-2);
//        minStack.push(0);
//        minStack.push(-3);
//        System.out.println(minStack.getMin()); // -3
//        minStack.pop();
//        System.out.println(minStack.top()); // 0
//        System.out.println(minStack.getMin()); // 2

        minStack.push(0);
        minStack.push(1);
        minStack.push(0);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}
