package Sword;
/*
剑指 Offer 11. 旋转数组的最小数字
把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。

示例 1：

输入：[3,4,5,1,2]
输出：1
示例 2：

输入：[2,2,2,0,1]
输出：0
 */
public class Offer11 {
//    public int minArray(int[] numbers) {
//        int len = numbers.length;
//        int left = 0;
//        int right = len - 1;
//        int mid = left;
//        while (numbers[left] >= numbers[right]) {
//            if (right - left == 1) {
//                mid = right;
//                break;
//            }
//            mid = left + (right - left) / 2;
//            if (numbers[left] == numbers[mid] && numbers[mid] == numbers[right]) {
//                mid = midInOrder(numbers, left, right);
//                break;
//            }
//            if (numbers[mid] >= numbers[left]) {
//                left = mid;
//            } else if (numbers[mid] <= numbers[right]) {
//                right = mid;
//            }
//        }
//        return numbers[mid];
//    }
//
//    private int midInOrder(int[] numbers, int left, int right) {
//        int min = numbers[left];
//        int res = left;
//        for (int i = left + 1; i <= right; i++) {
//            if (numbers[i] < min) {
//                min = numbers[i];
//                res = i;
//            }
//        }
//        return res;
//    }

    public int minArray(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (numbers[pivot] < numbers[high]) {
                high = pivot;
            } else if (numbers[pivot] > numbers[high]) {
                low = pivot + 1;
            } else {
                high -= 1;
            }
        }
        return numbers[low];
    }

    public static void main(String[] args) {
//        int[] numbers = new int[]{
//                2,2,2,0,1
//        };
//        int[] numbers = new int[]{
//                1,2,3,4,5
//        };
        int[] numbers = new int[]{
                3,1,3
        };
        System.out.println(new Offer11().minArray(numbers));
    }
}
