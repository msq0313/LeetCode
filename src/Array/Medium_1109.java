package Array;

import LeetCode.first_0301.Medium_11;

import java.util.Arrays;

/*
1109. 航班预订统计
这里有 n 个航班，它们分别从 1 到 n 进行编号。

我们这儿有一份航班预订表，表中第 i 条预订记录 bookings[i] = [i, j, k] 意味着我们在从 i 到 j 的每个航班上预订了 k 个座位。

请你返回一个长度为 n 的数组 answer，按航班编号顺序返回每个航班上预订的座位数。

示例：

输入：bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
输出：[10,55,45,25,25]

提示：

1 <= bookings.length <= 20000
1 <= bookings[i][0] <= bookings[i][1] <= n <= 20000
1 <= bookings[i][2] <= 10000
通过次数15,614提交次数32,311
 */
public class Medium_1109 {

    public static class DArray {
        int[] array;
        DArray(int[] nums) {
            array = new int[nums.length];
            array[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                array[i] = nums[i] - nums[i - 1];
            }
        }

        public void increment(int i, int j, int val) {
            array[i] += val;
            if (j + 1 < array.length) {
                array[j + 1] -= val;
            }
        }

        public int[] generate() {
            int[] nums = new int[array.length];
            nums[0] = array[0];
            for (int i = 1; i < array.length; i++) {
                nums[i] = nums[i - 1] + array[i];
            }
            return nums;
        }

    }

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] nums = new int[n];
        DArray dArray = new DArray(nums);
        for (int[] booking : bookings) {
            dArray.increment(booking[0]-1, booking[1]-1, booking[2]);
        }
        return dArray.generate();
    }

    public static void main(String[] args) {
        int[][] bookings = {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
        int n = 5;
        System.out.println(Arrays.toString(new Medium_1109().corpFlightBookings(bookings, n)));
    }
}
