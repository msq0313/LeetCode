package Sort_Algorithm;
// 无序数组中位数
// 快速排序思想，区间找轴值
public class UnSortedMid {
    private int getMiddle(int[] nums) {
        int mid = nums.length / 2;
        int left = 0;
        int right = nums.length - 1;
        int index = partition(nums, left, right);
        while (index != mid) {
            if (index < mid) {
                index = partition(nums, index + 1, right);
            } else {
                index = partition(nums, left, index - 1);
            }
        }
        return nums[index];
    }

    int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= pivot)
                right--;
            if (left < right)
                nums[left++] = nums[right];
            while (left < right && nums[left] <= pivot)
                left++;
            if (left < right)
                nums[right--] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{ 2, 1, 4, 7, 6, 8, 3, 6, 4, 7};
        int[] nums = new int[]{2, 1, 4, 5, 3};
        System.out.println(new UnSortedMid().getMiddle(nums));
    }
}
