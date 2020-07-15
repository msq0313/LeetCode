package Sort_Algorithm;

import java.util.Arrays;

public class MergeSort {
    public int[] sort(int[] nums) {
        //在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        int[] temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, temp);
        return nums;
    }

    private void mergeSort(int[] nums, int left, int right, int[] temp) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(nums, left, mid, temp);//左边归并排序，使得左子序列有序
            mergeSort(nums, mid + 1, right, temp);//右边归并排序，使得右子序列有序
            merge(nums, left, mid, right, temp);//将两个有序子数组合并操作
        }
    }

    private void merge(int[] nums, int left, int mid, int right, int[] temp) {
        int i = left;//左序列指针
        int j = mid + 1;//右序列指针
        int t = 0;//临时数组指针
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[t++] = nums[i++];
            } else {
                temp[t++] = nums[j++];
            }
        }
        while (i <= mid) {//将左边剩余元素填充进temp中
            temp[t++] = nums[i++];
        }
        while (j <= right) {//将右序列剩余元素填充进temp中
            temp[t++] = nums[j++];
        }
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while (left <= right) {
            nums[left++] = temp[t++];
        }
    }

    public static void main(String[] args) {
        int[] nums = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(new MergeSort().sort(nums)));
    }
}
