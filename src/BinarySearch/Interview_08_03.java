package BinarySearch;
/*
面试题 08.03. 魔术索引
魔术索引。 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。给定一个有序整数数组，
编写一种方法找出魔术索引，若有的话，在数组A中找出一个魔术索引，如果没有，则返回-1。若有多个魔术索引，
返回索引值最小的一个。

示例1:
0 1 2 3 4 5 6 7
1 1 1 2

0 1 2 3 4 5 6 7
1 2 3 4 5 5

0 1 2 3 4 5 6 7
1 1 1 4 5 5

0 1 2 3 4 5 6 7
1 2 3 4 5 5

 输入：nums = [0, 2, 3, 4, 5]
 输出：0
 说明: 0下标的元素为0
示例2:

 输入：nums = [1, 1, 1]
 输出：1
提示:

nums长度在[1, 1000000]之间
 */
public class Interview_08_03 {
    int res = -1;
    public int findMagicIndex(int[] nums) {
        binarySearch(nums, 0, nums.length - 1);
        return res;
    }

    public void binarySearch(int[] nums, int left, int right) {
        if (left > right) {
            return;
        }
        int mid = left + (right - left) / 2;
        if (nums[mid] == mid) {
            res = mid;
            // 相等，只搜左边
            binarySearch(nums, left, mid - 1);
        } else {
            // 不相等，先左后右
            binarySearch(nums, left, mid - 1);
            // 左边没找到，搜右边
            if (res == -1) {
                binarySearch(nums, mid + 1, right);
            }
        }
    }

//    public int findMagicIndex(int[] nums) {
//        int res = -1;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == i) {
//                res = i;
//                break;
//            }
//        }
//        return res;
//    }

    public static void main(String[] args) {
        int[] nums = new int[]{
                1, 2, 3, 4, 5, 5
        };
        System.out.println(new Interview_08_03().findMagicIndex(nums));
    }
}
