package Examination.ByteDance;

import java.util.Arrays;

/*
给一数组，让你找一对满足i<j && a[i]<a[j]的i和j  (O(N)时间复杂度 O(1)空间复杂度)
 */
public class FindTwoNum {
    public int[] solution(int[] nums) {
        int[] res = new int[2];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
                res[0] = i;
            }
            if (nums[i] > min) {
                res[1] = i;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{
                2,1,4
        };
        System.out.println(Arrays.toString(new FindTwoNum().solution(nums)));
    }
}
