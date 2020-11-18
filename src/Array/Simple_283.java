package Array;

import java.util.Arrays;

/*
283. 移动零
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

示例:

输入: [0,1,0,3,12]
输出: [1,3,12,0,0]
说明:

必须在原数组上操作，不能拷贝额外的数组。
尽量减少操作次数。
 */
public class Simple_283 {
    public int[] moveZeroes(int[] nums) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                int t = nums[left];
                nums[left] = nums[right];
                nums[right] = t;
                left++;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
//        int[] nums = {0, 0, 1};
        System.out.println(Arrays.toString(new Simple_283().moveZeroes(nums)));
    }
}
