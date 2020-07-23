package Examination.ByteDance;

import java.util.Arrays;

/*
给一数组，让你找一对满足i<j<k && a[i]<a[j]<a[k]   的i和j和k   (O(N)时间复杂度 O(N)空间复杂度)
 */
public class FindTwoNums2 {
    public int[] solution(int[] nums) {
        int[] res = new int[3];
        int count = 0;
        int temp = res[0];
        int start = 0;
        // 先找到一组i,j
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] < nums[res[0]]) {
                res[0] = j;
            }
            if (nums[j] > nums[res[0]]) {
                res[1] = j;
                start = j + 1;
                break;
            }
        }
        // 之后继续扫描
        for (int k = start; k < nums.length; k++) {
            if (nums[k] > nums[res[1]]) {
                res[2] = k;
                break;
            }
            if (nums[k] < nums[temp]) {
                temp = k;
                count++;
            }
            if (nums[k] > nums[temp] && nums[k] < nums[res[1]] && count == 1) {
                res[0] = temp;
                res[1] = k;
                count = 0;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{7, 2, 2, 7, 1, 8, 2, 3};
        System.out.println(Arrays.toString(new FindTwoNums2().solution(nums)));
    }
}
