package LeetCode.first_0301;

/*
55. 跳跃游戏
给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

判断你是否能够到达最后一个位置。

示例 1:
2 3 1 1 4
输入: [2,3,1,1,4]
输出: true
解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
示例 2:

输入: [3,2,1,0,4]
输出: false
解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。

 */
public class Medium_55 {

    public boolean canJump1(int[] num) {
        boolean res = false;
        int len = num.length;
        int max = 1;
        if (len == 1) {
            return true;
        }

        for (int i = 0; i < max && i < len - 1; i++) {
            int j = i;
            while (num[j] != 0) {
                j += num[j];
                max = Math.max(max, j);
                if (j >= len - 1) {
                    res = true;
                    break;
                }
            }
        }
        return res;
    }

    public boolean canJump(int[] num) {
        boolean res = false;
        int len = num.length;
        int max = 0;
        if (len == 1) {
            return true;
        }
        for (int i = 0; i < len - 1; i++) {
            if (i > max) {
                break;
            }
            max = Math.max(max, i + num[i]);
            if (max >= len - 1) {
                res = true;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] num = new int[]{2, 3, 1, 1, 4};
//        int[] num = new int[]{3, 2, 1, 0, 4};
//        int[] num = new int[]{2, 5, 0, 0};
//        int[] num = new int[]{0, 2, 3};
//        int[] num = new int[]{3, 0, 8, 2, 0, 0, 1};
        int[] num = new int[]{1, 0, 1, 0};
        Medium_55 medium_55 = new Medium_55();
        System.out.println(medium_55.canJump(num));
    }
}
