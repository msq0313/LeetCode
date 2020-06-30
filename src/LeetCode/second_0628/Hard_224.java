package LeetCode.second_0628;

import java.util.ArrayDeque;
import java.util.Deque;

/*
224. 基本计算器
实现一个基本的计算器来计算一个简单的字符串表达式的值。

字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格  。

示例 1:

输入: "1 + 1"
输出: 2
示例 2:

输入: " 2-1 + 2 "
输出: 3
示例 3:

输入: "(1+(4+5+2)-3)+(6+8)"
输出: 23
说明：

你可以假设所给定的表达式都是有效的。
请不要使用内置的库函数 eval。

 */
public class Hard_224 {

    public int calculate(String s) {
        return recurrence(s);
    }

    public int recurrence(String s) {
        int res = 0;
        int num = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                int count = 1;
                //递归计算后续字符串
                num = recurrence(s.substring(i + 1, s.length() - 1));

                //调整指针i的位置
                while (count != 0) {
                    i++;
                    if (s.charAt(i) == '(') {
                        count++;
                    }
                    if (s.charAt(i) == ')') {
                        count--;
                        if (count == 0) {
                            break;
                        }
                    }
                }
                if (i != s.length() - 1)
                    i++;
                c = s.charAt(i);
            }
            //数字累加
            if (c >= '0' && c <= '9') {
                num *= 10;
                num += (c - '0');
            }
            //利用之前记录的符号计算，并记录当前符号
            if (c == '+' || c == '-' || i == s.length() - 1 || c == ')') {
                switch (sign) {
                    case '+': stack.push(num);break;
                    case '-': stack.push(-num);break;
                }
                if (c == ')') {
                    break;
                }
                sign = c;
                num = 0;
            }
        }
        //当前表达式内的项累加
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

//    public int calculate(String s) {
//
//        Stack<Integer> stack = new Stack<Integer>();
//        int operand = 0;
//        int result = 0; // For the on-going result
//        int sign = 1;  // 1 means positive, -1 means negative
//
//        for (int i = 0; i < s.length(); i++) {
//
//            char ch = s.charAt(i);
//            if (Character.isDigit(ch)) {
//
//                // Forming operand, since it could be more than one digit
//                operand = 10 * operand + (int) (ch - '0');
//
//            } else if (ch == '+') {
//
//                // Evaluate the expression to the left,
//                // with result, sign, operand
//                result += sign * operand;
//
//                // Save the recently encountered '+' sign
//                sign = 1;
//
//                // Reset operand
//                operand = 0;
//
//            } else if (ch == '-') {
//
//                result += sign * operand;
//                sign = -1;
//                operand = 0;
//
//            } else if (ch == '(') {
//
//                // Push the result and sign on to the stack, for later
//                // We push the result first, then sign
//                stack.push(result);
//                stack.push(sign);
//
//                // Reset operand and result, as if new evaluation begins for the new sub-expression
//                sign = 1;
//                result = 0;
//
//            } else if (ch == ')') {
//
//                // Evaluate the expression to the left
//                // with result, sign and operand
//                result += sign * operand;
//
//                // ')' marks end of expression within a set of parenthesis
//                // Its result is multiplied with sign on top of stack
//                // as stack.pop() is the sign before the parenthesis
//                result *= stack.pop();
//
//                // Then add to the next operand on the top.
//                // as stack.pop() is the result calculated before this parenthesis
//                // (operand on stack) + (sign on stack * (result from parenthesis))
//                result += stack.pop();
//
//                // Reset the operand
//                operand = 0;
//            }
//        }
//        return result + (sign * operand);
//    }

    public static void main(String[] args) {
        String s = "(1+(4+5+2)-3) + (6+8)";
//        String s = "(1+(4+5+2)-3)";
        System.out.println(new Hard_224().calculate(s));
    }
}
