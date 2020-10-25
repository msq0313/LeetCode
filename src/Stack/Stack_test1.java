package Stack;

import java.util.Arrays;
import java.util.Stack;
// 2 1 2 4 3
// 4 2 4 -1 -1
public class Stack_test1 {
    public int[] nextGreatNum(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {

            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);

        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 2, 4, 3};
        System.out.println(Arrays.toString(new Stack_test1().nextGreatNum(nums)));
    }
}
