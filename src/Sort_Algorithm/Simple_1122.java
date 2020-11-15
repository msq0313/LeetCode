package Sort_Algorithm;

import java.util.*;

/*
1122. 数组的相对排序
给你两个数组，arr1 和 arr2，

arr2 中的元素各不相同
arr2 中的每个元素都出现在 arr1 中
对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。



示例：

输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
输出：[2,2,2,1,4,3,3,9,6,7,19]


提示：

arr1.length, arr2.length <= 1000
0 <= arr1[i], arr2[i] <= 1000
arr2 中的元素 arr2[i] 各不相同
arr2 中的每个元素 arr2[i] 都出现在 arr1 中
通过次数48,134提交次数68,054
 */
public class Simple_1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] count = new int[1001];
        int[] res = new int[arr1.length];
        List<Integer> list = new ArrayList<>();
        for (int i : arr1) {
            count[i]++;
        }
        for (int i : arr2) {
            while (count[i] > 0) {
                list.add(i);
                count[i]--;
            }
        }
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                list.add(i);
                count[i]--;
            }
        }
        for (int i = 0; i < arr1.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};
        System.out.println(Arrays.toString(new Simple_1122().relativeSortArray(arr1, arr2)));
    }
}
