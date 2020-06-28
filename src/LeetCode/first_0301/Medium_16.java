package LeetCode.first_0301;

import java.util.Arrays;

/*
16. 最接近的三数之和
给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。

示例：

输入：nums = [-1,2,1,-4], target = 1
输出：2
解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。

提示：

3 <= nums.length <= 10^3
-10^3 <= nums[i] <= 10^3
-10^4 <= target <= 10^4

 */
public class Medium_16 {
    //排序加双指针，初始想法是三层循环，此时可考虑对a进行for循环，其余两个变量按双指针法，相向遍历
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int res = 10000;
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                res = Math.abs(res - target) < Math.abs(sum - target) ? res : sum;
                if (sum == target) {
                    return sum;
                }
                if (sum > target) {
                    right--;
                }
                if (sum < target) {
                    left++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        //1
//        int[] nums = new int[]{
//                -1,2,1,-4
//        };
//        int target = 1;
        //2
//        int[] nums = new int[]{
//                -1,2,0,-4,3
//        };
//        int target = 1;
        //3
//        int[] nums = new int[]{
//                0,1,2
//        };
//        int target = 3;
        //4
//        int[] nums = new int[]{
//                -3,0,1,2
//        };
//        int target = 1;
        //5
        int[] nums = new int[]{
                -3,-2,-5,3,-4
        };
        int target = -1;

        System.out.println(new Medium_16().threeSumClosest(nums, target));
    }
}
