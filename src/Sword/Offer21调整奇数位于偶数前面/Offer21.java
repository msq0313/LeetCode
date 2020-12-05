package Sword.Offer21调整奇数位于偶数前面;

import java.util.Arrays;

/*
剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。

示例：

输入：nums = [1,2,3,4]
输出：[1,3,2,4]
注：[3,1,2,4] 也是正确的答案之一。

提示：

1 <= nums.length <= 50000
1 <= nums[i] <= 10000
 */
public class Offer21 {
    public int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] % 2 < nums[right] % 2) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
            if (nums[left] % 2 == 1) {
                left++;
            }
            if (nums[right] % 2 == 0) {
                right--;
            }
        }
        return nums;
    }

    public int[] exchange2(int[] nums) {
        int p = 0;
        int len = nums.length;
        for(int i = 0; i < len; i ++){
            if((nums[i]&1)==1){
                int tmp = nums[i];
                nums[i] = nums[p];
                nums[p++] = tmp;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        System.out.println(Arrays.toString(new Offer21().exchange(nums)));
    }
}
